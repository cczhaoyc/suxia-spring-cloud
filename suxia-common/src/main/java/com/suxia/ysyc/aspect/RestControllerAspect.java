package com.suxia.ysyc.aspect;

import com.alibaba.fastjson.JSON;
import com.suxia.ysyc.enums.RestTypeEnum;
import com.suxia.ysyc.exception.BusinessException;
import com.suxia.ysyc.exception.SystemException;
import com.suxia.ysyc.exception.enums.SystemExceptionEnum;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 统一请求拦截并记录异常日志
 * </p>
 *
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date 2020/4/22 10:35
 */
@Aspect
@Component
public class RestControllerAspect {

    private static final Logger LOG = LoggerFactory.getLogger(RestControllerAspect.class);

    @Pointcut("execution(* com.suxia.ysyc.controller..*.*(..)) ")
    public void executionMethod() {
    }

    @Around("executionMethod()")
    public Object handlerControllerMethod(ProceedingJoinPoint pjp) {
        long startTime = System.currentTimeMillis();
        HttpServletRequest request;
        try {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            Object[] args = pjp.getArgs();
            if (attributes != null) {
                request = attributes.getRequest();
                LOG.info("请求URL-->{}", request.getRequestURI());
                LOG.info("请求Method-->{}", request.getMethod());
            }
            LOG.info("请求类和方法-->{}", pjp.getSignature());
            LOG.info("请求参数-->{}", StringUtils.join(args, ":"));
            Object obj = pjp.proceed();
            LOG.info("请求结果-->{}", JSON.toJSONString(obj));
            LOG.info("请求耗时-->{}ms", (System.currentTimeMillis() - startTime));
            return obj;
        } catch (BusinessException e) {
            LOG.error("ServiceException--------->" + pjp.getSignature() + " [type=" + e.getType().name() + ",code=" + e.getCode() + ",message=" + e.getMessage() + "]", e);
            throw e;
        } catch (Throwable e) {
            LOG.error("SystemException--------->" + pjp.getSignature() + " [type=" + RestTypeEnum.error.name() + ",code=" + SystemExceptionEnum.EX_10000.getCode() + ",message=" + e.getMessage() + "]", e);
            throw new SystemException(SystemExceptionEnum.EX_10000.getCode(), e.getMessage(), e);
        }
    }
}