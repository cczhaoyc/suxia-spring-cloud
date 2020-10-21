package com.suxia.ysyc.config;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.suxia.ysyc.constants.AutoStarterConstants;
import com.suxia.ysyc.domain.SnowflakeWorker;
import com.suxia.ysyc.exception.BusinessException;
import com.suxia.ysyc.service.RedisService;
import com.suxia.ysyc.utils.PublicNetIpUtil;
import com.suxia.ysyc.utils.StringJoinerUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.Random;


/**
 * <p>
 * 雪花算法自动配置
 * </p>
 *
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date 2020/8/9 12:56
 */
@Configuration
@ConditionalOnProperty(prefix = AutoStarterConstants.SNOWFLAKE_PREFIX, name = AutoStarterConstants.ENABLE_NAME, havingValue = AutoStarterConstants.TRUE_HAVING_VALUE)
@Slf4j
public class SnowflakeConfig {

    /**
     * workerId下key=dataCenterId:workerId唯一
     */
    public static final String WORKER_ID = "snowflake";
    public static final String IP = "ip";
    public static final String ID = "id";

    @Value("${server.port}")
    private Integer port;

    @Resource
    private RedisService redisService;

    /**
     * <p>
     * SnowflakeIdWorker初始化
     * </p>
     *
     * @author cczhaoyc@163.com
     * @date 2020/7/24 10:19
     */
    @Bean
    public Snowflake snowflakeIdWorker() {
        SnowflakeWorker snowflakeWorker = this.getSnowflakeWorkerId();
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +
                "[Snowflake初始化完成]" +
                "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        return IdUtil.getSnowflake(snowflakeWorker.getWorkerId(), snowflakeWorker.getDataCenterId());
    }

    /**
     * <p>
     * 获取Snowflake workerId
     * </p>
     *
     * @author cczhaoyc@163.com
     * @date 2020/7/24 10:18
     */
    private SnowflakeWorker getSnowflakeWorkerId() {
        String serverIp = PublicNetIpUtil.publicNetIp();
        if (StringUtils.isBlank(serverIp)) {
            throw new BusinessException("Snowflake初始化异常，serverIp=" + serverIp + "，serverPort=" + port);
        }
        String ipKey = StringJoinerUtil.build(WORKER_ID, IP, serverIp, String.valueOf(port));
        SnowflakeWorker oldWorkerId = redisService.getNoRedisKeyPrefix(ipKey, SnowflakeWorker.class);
        if (oldWorkerId != null) {
            log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +
                    "[Snowflake workerId]已存在，ip:port=[" + serverIp + ":" + port + "]" +
                    "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +
                    "[Snowflake workerId]已存在，workerId:dataCenterId=[" + oldWorkerId.getWorkerId() + ":" + oldWorkerId.getDataCenterId() + "]" +
                    "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            return oldWorkerId;
        }
        // ip:port不存在时自动生成workId
        SnowflakeWorker newWorkerId = this.getNewWorkerId();
        redisService.putForeverNoRedisKeyPrefix(ipKey, newWorkerId);

        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +
                "[Snowflake workerId]自动生成，ip:port=[" + serverIp + ":" + port + "]" +
                "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +
                "[Snowflake workerId]自动生成，workerId:dataCenterId=[" + newWorkerId.getWorkerId() + ":" + newWorkerId.getDataCenterId() + "]" +
                "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        return newWorkerId;
    }

    /**
     * <p>
     * 验证缓存workerId
     * </p>
     *
     * @author cczhaoyc@163.com
     * @date 2020/7/13 9:46
     */
    private SnowflakeWorker getNewWorkerId() {
        // ip:port不存在时自动生成workId
        SnowflakeWorker newSnowflakeWorkerId = this.getNewId();
        // 去验证workId是否存在
        String idKey = StringJoinerUtil.build(WORKER_ID, ID, String.valueOf(newSnowflakeWorkerId.getWorkerId()), String.valueOf(newSnowflakeWorkerId.getDataCenterId()));
        SnowflakeWorker redisSnowflakeWorkerId = redisService.getNoRedisKeyPrefix(idKey, SnowflakeWorker.class);
        if (redisSnowflakeWorkerId != null) {
            this.getNewWorkerId();
        }
        redisService.putForeverNoRedisKeyPrefix(idKey, newSnowflakeWorkerId);
        return newSnowflakeWorkerId;
    }

    /**
     * <p>
     * 随机生成[0,31]以内的数字作为workerId和dataCenterId
     * </p>
     *
     * @author cczhaoyc@163.com
     * @date 2020/8/9 13:34
     */
    private SnowflakeWorker getNewId() {
        Random random = new Random();
        long dataCenterId = random.nextInt(32);
        long workerId = random.nextInt(32);
        SnowflakeWorker snowflakeWorker = new SnowflakeWorker();
        snowflakeWorker.setDataCenterId(dataCenterId);
        snowflakeWorker.setWorkerId(workerId);
        return snowflakeWorker;
    }

}
