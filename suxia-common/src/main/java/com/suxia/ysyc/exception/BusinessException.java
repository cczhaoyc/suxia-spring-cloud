package com.suxia.ysyc.exception;


import com.suxia.ysyc.enums.RestTypeEnum;
import com.suxia.ysyc.exception.enums.BusinessExceptionEnum;

/**
 * <p>
 * 业务异常
 * </p>
 *
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date 2020/8/9 10:50
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 514187374144179841L;

    private Integer code;
    private BusinessExceptionEnum businessExceptionEnum;
    private RestTypeEnum type;

    public BusinessException() {
        super(BusinessExceptionEnum.EX_80000.getMessage());
        this.code = BusinessExceptionEnum.EX_80000.getCode();
        this.type = RestTypeEnum.warn;
    }

    public BusinessException(String message) {
        super(message);
        this.code = BusinessExceptionEnum.EX_80000.getCode();
        this.type = RestTypeEnum.warn;
    }

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
        this.type = RestTypeEnum.warn;
    }

    public BusinessException(BusinessExceptionEnum businessExceptionEnum) {
        super(businessExceptionEnum.getMessage());
        this.code = businessExceptionEnum.getCode();
        this.type = businessExceptionEnum.getType();
    }

    public BusinessException(BusinessExceptionEnum businessExceptionEnum, String message) {
        super(businessExceptionEnum.getMessage() + " " + message);
        this.code = businessExceptionEnum.getCode();
        this.type = businessExceptionEnum.getType();
    }

    public BusinessException(BusinessExceptionEnum businessExceptionEnum, Throwable cause) {
        super(businessExceptionEnum.getMessage(), cause);
        this.code = businessExceptionEnum.getCode();
        this.type = businessExceptionEnum.getType();
    }

    public BusinessException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.type = RestTypeEnum.warn;
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

    public BusinessExceptionEnum getBusinessExceptionEnum() {
        return businessExceptionEnum;
    }

    public void setBusinessExceptionEnum(BusinessExceptionEnum businessExceptionEnum) {
        this.businessExceptionEnum = businessExceptionEnum;
    }
}