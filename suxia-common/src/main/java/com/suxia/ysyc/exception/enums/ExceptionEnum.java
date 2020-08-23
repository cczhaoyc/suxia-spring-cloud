package com.suxia.ysyc.exception.enums;

/**
 * <p>
 * 异常枚举
 * </p>
 *
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date 2020/8/9 10:50
 */
public enum ExceptionEnum {

    /**
     * 系统异常编码从10000-19999，描述自定义
     */
    SYSTEM_EX_START_10000(10000, "系统异常"),
    /**
     * 未登录异常编码从20000-29999，描述自定义
     */
    NO_LOGIN_EX_START_20000(20000, "未登录异常"),
    /**
     * Redis异常编码从30000-39999，描述自定义
     */
    REDIS_EX_START_30000(30000, "Redis异常"),
    /**
     * Rabbit异常编码从40000-49999，描述自定义
     */
    RABBIT_EX_START_40000(40000, "Rabbit异常"),

    PARAMS_EX_START_50000(50000, "参数异常"),
    /**
     * seata分布式事务异常
     */
    SEATA_EX_START_60000(60000, "seata分布式事务异常"),
    /**
     * 业务异常编码从80000-99999，描述自定义
     */
    Business_EX_START_80000(80000, "业务异常");


    private Integer code;
    private String message;

    ExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
