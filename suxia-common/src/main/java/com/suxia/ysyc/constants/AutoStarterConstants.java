package com.suxia.ysyc.constants;

/**
 * <p>
 * 自动装配参数常量池
 * </p>
 *
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date 2020/8/7 9:34
 */
public interface AutoStarterConstants {

    /**
     * suxia
     */
    String ENABLE_NAME = "enable";
    String TRUE_HAVING_VALUE = "true";
    String SUXIA_PREFIX = "suxia";
    /**
     * snowflake
     */
    String SNOWFLAKE_PREFIX = SUXIA_PREFIX + ".snowflake";
    /**
     * swagger
     */
    String SWAGGER_PREFIX = SUXIA_PREFIX + ".swagger";
    /**
     * security
     */
    String SECURITY_PREFIX = SUXIA_PREFIX + ".security";
    String SECURITY_OAUTH2_PREFIX = SECURITY_PREFIX + ".oauth2";
    /**
     * xxl-job
     */
    String XXL_PREFIX = SUXIA_PREFIX + ".xxl";
    String XXL_JOB_PREFIX = XXL_PREFIX + ".job";
    /**
     * rabbitmq
     */
    String RABBITMQ_PREFIX = SUXIA_PREFIX + ".rabbitmq";
    /**
     * redis
     */
    String REDIS_PREFIX = SUXIA_PREFIX + ".redis";
    /**
     * seata
     */
    String SEATA_PREFIX = SUXIA_PREFIX + ".seata";
    /**
     * thread-pool
     */
    String THREAD_POOL = SUXIA_PREFIX + ".thread-pool";
}
