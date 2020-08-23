package com.suxia.ysyc.exception.enums;

/**
 * <p>
 * 业务异常描述
 * </p>
 *
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date 2020/8/9 10:48
 */
public enum BusinessExceptionEnum {

    /**
     * 业务异常
     */
    EX_80000(ExceptionEnum.Business_EX_START_80000.getCode(), ExceptionEnum.Business_EX_START_80000.getMessage()),
    /**
     *
     */
    EX_80001(80001, ""),

    ;

    private Integer code;
    private String message;

    BusinessExceptionEnum(Integer code, String message) {
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
