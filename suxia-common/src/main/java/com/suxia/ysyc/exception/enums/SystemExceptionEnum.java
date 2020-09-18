package com.suxia.ysyc.exception.enums;


import com.suxia.ysyc.enums.RestTypeEnum;

/**
 * <p>
 * 系统异常枚举
 * </p>
 *
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date 2020/9/10 11:45
 */
public enum SystemExceptionEnum {

    EX_10000(RestExceptionEnum.SYSTEM_EX_START_10000.getType(), RestExceptionEnum.SYSTEM_EX_START_10000.getCode(), RestExceptionEnum.SYSTEM_EX_START_10000.getMessage()),
    /**
     * 获取本机外网ip失败
     */
    EX_10001(RestTypeEnum.error, 10001, "获取本机外网ip失败"),
    /**
     * 缺少请求参数
     */
    EX_10002(RestTypeEnum.warn, 10002, "缺少请求参数"),
    /**
     * 参数解析失败
     */
    EX_10003(RestTypeEnum.warn, 10003, "参数解析失败"),
    /**
     * 参数验证失败
     */
    EX_10004(RestTypeEnum.warn, 10004, "参数验证失败"),
    /**
     * 参数绑定失败
     */
    EX_10005(RestTypeEnum.warn, 10005, "参数绑定失败"),
    /**
     * 方法参数约束违例异常
     */
    EX_10006(RestTypeEnum.warn, 10006, "方法参数约束违例异常"),
    /**
     * 参数验证失败
     */
    EX_10007(RestTypeEnum.warn, 10007, "参数验证失败"),
    /**
     * HTTP请求方法不支持
     */
    EX_10008(RestTypeEnum.warn, 10008, "HTTP请求方法不支持"),
    /**
     * 不支持当前媒体类型
     */
    EX_10009(RestTypeEnum.warn, 10009, "不支持当前媒体类型"),
    /**
     * 方法参数类型不匹配异常
     */
    EX_10010(RestTypeEnum.warn, 10010, "方法参数类型不匹配异常"),
    /**
     * 文件上传超出最大限制
     */
    EX_10011(RestTypeEnum.warn, 10011, "文件上传超出最大限制");

    private RestTypeEnum type;
    private Integer code;
    private String message;

    SystemExceptionEnum(RestTypeEnum type, Integer code, String message) {
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
