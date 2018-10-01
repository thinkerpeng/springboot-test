package com.pwx.spring.result;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by pengweixiang on 2018/10/1.
 * 异常日志记录切面类
 */
@Aspect
@Component
public class HttpAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpAspect.class);

    @Autowired
    private ExceptionHandle exceptionHandle;

    @Pointcut("execution(public * com.pwx.spring.mvc.controller.*.*(..))")
    public void log(){}

    @Before("log()")
    public void doBefore(JoinPoint joinpoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        LOGGER.info("url={}", request.getRequestURL());
        LOGGER.info("method={}", request.getMethod());
        LOGGER.info("RemoteIP={}", request.getRemoteAddr());
        LOGGER.info("class_method={}", joinpoint.getSignature().getDeclaringTypeName() +
                    ", " + joinpoint.getSignature().getName());
        LOGGER.info("args={}", joinpoint.getArgs());
    }

    @Around("log()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Result result = null;
        try {

        } catch (Exception e) {
            return exceptionHandle.exceptionGet(e);
        }
        if (result == null) {
            return proceedingJoinPoint.proceed();
        } else {
            return result;
        }
    }

    //打印输出结果
    @AfterReturning(pointcut = "log()", returning = "object")
    public void doAfterReturning(Object object) {
        LOGGER.info("response={}", object.toString());
    }
}
