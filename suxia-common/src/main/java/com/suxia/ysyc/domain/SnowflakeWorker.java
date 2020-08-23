package com.suxia.ysyc.domain;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * SnowflakeWorker属性
 * </p>
 *
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date 2020/8/9 12:51
 */
@Data
public class SnowflakeWorker implements Serializable {

    private static final long serialVersionUID = 5602963233096648254L;
    /**
     * 数据中心id
     */
    private Long dataCenterId;
    /**
     * 工作id
     */
    private Long workerId;

    /**
     * 服务外网ip
     */
    private String ip;

    /**
     * 服务端口
     */
    private Integer port;

    /**
     * 服务名
     */
    private String applicationName;

    /**
     * 文件使用次数
     */
    private Integer fileUsedTimes;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 最后更新时间
     */
    private LocalDateTime updateTime;
}
