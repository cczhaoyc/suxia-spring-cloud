package com.suxia.ysyc.exception.enums;

import com.suxia.ysyc.enums.RestTypeEnum;

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
    EX_80000(RestExceptionEnum.Business_EX_START_80000.getType(), RestExceptionEnum.Business_EX_START_80000.getCode(), RestExceptionEnum.Business_EX_START_80000.getMessage()),

    /**
     * 用户名不能为空
     */
    EX_80001(RestTypeEnum.warn, 80001, "用户名不能为空");

    private Integer code;
    private String message;
    private RestTypeEnum type;

    BusinessExceptionEnum(RestTypeEnum type, Integer code, String message) {
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
