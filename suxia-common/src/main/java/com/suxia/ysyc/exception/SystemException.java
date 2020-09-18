package com.suxia.ysyc.exception;


import com.suxia.ysyc.domain.RestResult;
import com.suxia.ysyc.enums.RestTypeEnum;
import com.suxia.ysyc.exception.enums.SystemExceptionEnum;

/**
 * <p>
 * 系统异常
 * </p>
 *
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date 2020/9/10 11:45
 */
public class SystemException extends RuntimeException {

    private static final long serialVersionUID = -3792182504254740713L;

    private Integer code;
    private SystemExceptionEnum systemExceptionEnum;
    private RestTypeEnum type;

    public SystemException(String message) {
        super(message);
        this.code = RestResult.ERROR_CODE;
        this.type = RestTypeEnum.error;
    }

    public SystemException(Integer code, String message) {
        super(message);
        this.code = code;
        this.type = RestTypeEnum.error;
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
        this.code = RestResult.ERROR_CODE;
        this.type = RestTypeEnum.error;
    }

    public SystemException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.type = RestTypeEnum.error;
    }

    public SystemException(SystemExceptionEnum systemExceptionEnum) {
        super(systemExceptionEnum.getMessage());
        this.code = systemExceptionEnum.getCode();
        this.type = systemExceptionEnum.getType();
    }

    public SystemException(SystemExceptionEnum systemExceptionEnum, Throwable cause) {
        super(systemExceptionEnum.getMessage(), cause);
        this.code = systemExceptionEnum.getCode();
        this.type = systemExceptionEnum.getType();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public SystemExceptionEnum getSystemExceptionEnum() {
        return systemExceptionEnum;
    }

    public void setSystemExceptionEnum(SystemExceptionEnum systemExceptionEnum) {
        this.systemExceptionEnum = systemExceptionEnum;
    }

    public RestTypeEnum getType() {
        return type;
    }

    public void setType(RestTypeEnum type) {
        this.type = type;
    }
}
