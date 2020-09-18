package com.suxia.ysyc.exception.enums;

import com.suxia.ysyc.enums.RestTypeEnum;

/**
 * <p>
 * 异常枚举
 * </p>
 *
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date 2020/8/9 10:50
 */
public enum RestExceptionEnum {

    /**
     * 系统异常编码从10000-19999，描述自定义
     */
    SYSTEM_EX_START_10000(RestTypeEnum.error, 10000, "系统异常"),
    /**
     * 业务异常编码从80000-99999，描述自定义
     */
    Business_EX_START_80000(RestTypeEnum.warn, 80000, "业务异常");

    private RestTypeEnum type;
    private Integer code;
    private String message;

    RestExceptionEnum(RestTypeEnum type, Integer code, String message) {
        this.type = type;
        this.code = code;
        this.message = message;
    }

    public RestTypeEnum getType() {
        return type;
    }

    public void setType(RestTypeEnum type) {
        this.type = type;
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
