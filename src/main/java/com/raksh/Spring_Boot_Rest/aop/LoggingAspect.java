package com.raksh.Spring_Boot_Rest.aop;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;


@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    //before advice order-> return type,fully qualified class name,method-name and arguments
    @Before("execution(* com.raksh.Spring_Boot_Rest.service.JobService.*(..))")
    public void logMethodCall(JoinPoint jp){
        LOGGER.info("Method which was called is "+jp.getSignature().getName());
    }

    @After("execution(* com.raksh.Spring_Boot_Rest.service.JobService.*(..))")
    public void logMethodExec(JoinPoint jp){
        LOGGER.info("Method which was executed is "+jp.getSignature().getName());
    }
}
