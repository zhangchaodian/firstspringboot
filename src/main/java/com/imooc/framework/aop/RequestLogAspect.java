package com.imooc.framework.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

// @Aspect 注解是将一个java类定义为一个切面类
@Aspect
@Component
public class RequestLogAspect {
    private static final Logger logger = LoggerFactory.getLogger(RequestLogAspect.class);

    // 定义了一个切入点，可以是正则表达式 第一个*表示拦截的方法的返回值是任意的
    @Pointcut("execution(public * com.imooc.framework.web..*.*(..))")
    public void webLog() {}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("IP :" + request.getRemoteAddr());
    }


    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturing(Object ret) {
        // 处理完请求，返回内容
        logger.info("RESPONSE :" + ret);
    }
}
