package org.jz.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.jz.util.RandomUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

/**
 * Api controller aspect
 *
 * @author Hongyi Zheng
 * @date 2018/2/24
 */
@Aspect
@Component
public class ApiControllerAspect {

    final static Logger logger = LoggerFactory.getLogger(ApiControllerAspect.class);

    @Pointcut("execution(* org.jz.controller..*(..))&& @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void controllerMethodPointcut(){}

    @Around("controllerMethodPointcut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable{

        long threadId = Thread.currentThread().getId();
        String traceId = RandomUtil.getTraceId();
        String targetName = pjp.getTarget().getClass().getName();
        String methodName = pjp.getSignature().getName();

        MDC.put("threadId",String.valueOf(threadId) + "-" + traceId);
        logger.info("AOP cut-in --> " +targetName +"->" +methodName + "()");

        logger.info("Request traceId --> {}",traceId);
        return pjp.proceed();

    }

}

