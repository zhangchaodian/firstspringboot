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
// 加上这个@Componet是为了使这个Aspect作为一个bean注入托管到 Spring IOC里面去管理
@Aspect
@Component
public class RequestLogAspect {
    // 创建日志实例
    private static final Logger logger = LoggerFactory.getLogger(RequestLogAspect.class);

    // 告诉这个切面类，切入的点在哪里
    // 定义了一个切入点，可以是正则表达式
    // 第一个*表示拦截的方法的返回值是任意的
    // execution表示切入点在后面括号里的时机执行，在方法属性为public，然后package在com.imooc.framework.web底下的所有方法..*.*(..)
    @Pointcut("execution(public * com.imooc.framework.web..*.*(..))")
    public void webLog() {}

    // 这个注解表示在切入点开始处切入内容
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("IP :" + request.getRemoteAddr());
    }


    // 表示在切入点return内容后再切入，可以使用这个注解对返回值做一些加工处理
    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturing(Object ret) {
        // 处理完请求，返回内容
        logger.info("RESPONSE :" + ret);
    }
}
