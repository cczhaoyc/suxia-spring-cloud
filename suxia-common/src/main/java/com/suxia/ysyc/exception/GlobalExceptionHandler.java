package com.suxia.ysyc.exception;

import com.suxia.ysyc.domain.RestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <p>
 * 统一异常处理
 * </p>
 *
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date 2020/9/11 14:07
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * <p>
     * 业务异常
     * </p>
     *
     * @author cczhaoyc@163.com
     * @date 2020/9/11 14:08
     */
    @ExceptionHandler(BusinessException.class)
    private RestResult<?> handlerBusinessException(BusinessException e) {
        int code = null == e.getCode() ? RestResult.ERROR_CODE : e.getCode();
        RestResult<?> result = RestResult.create(code, e.getMessage(), e.getType());
        LOG.error("BusinessException-----> 业务异常: [type=" + e.getType().name() + ",code=" + e.getCode() + ",message=" + e.getMessage() + "]", e);
        return result;
    }

    /**
     * <p>
     * 系统异常
     * </p>
     *
     * @author cczhaoyc@163.com
     * @date 2020/9/11 14:08
     */
    @ExceptionHandler(SystemException.class)
    public RestResult<?> handlerSystemException(SystemException e) {
        int code = null == e.getCode() ? RestResult.ERROR_CODE : e.getCode();
        RestResult<?> result = RestResult.create(code, e.getMessage(), e.getType());
        LOG.error("SystemException-----> 系统异常: [type=" + e.getType().name() + ",code=" + e.getCode() + ",message=" + e.getMessage() + "]", e);
        return result;
    }

}