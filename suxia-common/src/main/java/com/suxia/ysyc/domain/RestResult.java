package com.suxia.ysyc.domain;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.LocalDateTimeUtil;
import com.suxia.ysyc.enums.RestTypeEnum;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 统一返回格式
 * </p>
 *
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date 2020/8/7 13:40
 */
public class RestResult<T> implements Serializable {

    private static final long serialVersionUID = -3622188389910811766L;

    public static final Integer SUCCESS_CODE = 200;
    public static final String SUCCESS_MESSAGE = "成功";
    public static final Integer ERROR_CODE = 500;
    public static final String ERROR_MESSAGE = "失败";

    private String type;
    private String message;
    private Integer code;
    private T data;
    private String time = LocalDateTimeUtil.format(LocalDateTime.now(), DatePattern.NORM_DATETIME_PATTERN);

    public static <T> RestResult<T> create(Integer code, String message, RestTypeEnum type) {
        RestResult<T> result = new RestResult<>();
        result.setCode(code);
        result.setMessage(message);
        result.setType(type.name());
        return result;
    }

    public static <T> RestResult<T> success() {
        RestResult<T> result = new RestResult<>();
        result.setCode(SUCCESS_CODE);
        result.setMessage(SUCCESS_MESSAGE);
        result.setType(RestTypeEnum.success.name());
        return result;
    }

    public static <T> RestResult<T> success(T data) {
        RestResult<T> result = new RestResult<>();
        result.setData(data);
        result.setCode(SUCCESS_CODE);
        result.setMessage(SUCCESS_MESSAGE);
        result.setType(RestTypeEnum.success.name());
        return result;
    }

    public static <T> RestResult<T> success(String message, T data) {
        RestResult<T> result = new RestResult<>();
        result.setData(data);
        result.setCode(SUCCESS_CODE);
        result.setMessage(message);
        result.setType(RestTypeEnum.success.name());
        return result;
    }

    public static <T> RestResult<T> success(Integer code, String message) {
        RestResult<T> result = new RestResult<>();
        result.setCode(code);
        result.setMessage(message);
        result.setType(RestTypeEnum.success.name());
        return result;
    }

    public static <T> RestResult<T> success(Integer code, String message, T data) {
        RestResult<T> result = new RestResult<>();
        result.setData(data);
        result.setCode(code);
        result.setMessage(message);
        result.setType(RestTypeEnum.success.name());
        return result;
    }

    public static <T> RestResult<T> success(Integer code, String message, T data, RestTypeEnum type) {
        RestResult<T> result = new RestResult<>();
        result.setData(data);
        result.setCode(code);
        result.setMessage(message);
        result.setType(type.name());
        return result;
    }

    public static <T> RestResult<T> error() {
        RestResult<T> result = new RestResult<>();
        result.setMessage(ERROR_MESSAGE);
        result.setCode(ERROR_CODE);
        result.setType(RestTypeEnum.error.name());
        return result;
    }

    public static <T> RestResult<T> error(T data) {
        RestResult<T> result = new RestResult<>();
        result.setData(data);
        result.setMessage(ERROR_MESSAGE);
        result.setCode(ERROR_CODE);
        result.setType(RestTypeEnum.error.name());
        return result;
    }

    public static <T> RestResult<T> error(String message, T data) {
        RestResult<T> result = new RestResult<>();
        result.setData(data);
        result.setCode(ERROR_CODE);
        result.setMessage(message);
        result.setType(RestTypeEnum.error.name());
        return result;
    }

    public static <T> RestResult<T> error(Integer code, String message) {
        RestResult<T> result = new RestResult<>();
        result.setCode(code);
        result.setMessage(message);
        result.setType(RestTypeEnum.error.name());
        return result;
    }

    public static <T> RestResult<T> error(Integer code, String message, T data) {
        RestResult<T> result = new RestResult<>();
        result.setData(data);
        result.setCode(code);
        result.setMessage(message);
        result.setType(RestTypeEnum.error.name());
        return result;
    }

    public static <T> RestResult<T> error(Integer code, String message, T data, RestTypeEnum type) {
        RestResult<T> result = new RestResult<>();
        result.setData(data);
        result.setCode(code);
        result.setMessage(message);
        result.setType(type.name());
        return result;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "RestResult={" +
                "message='" + message +
                ", code=" + code +
                ", data=" + data +
                ", time=" + time + '}';
    }
}
