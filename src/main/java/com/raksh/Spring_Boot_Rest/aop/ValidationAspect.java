package com.raksh.Spring_Boot_Rest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component  // Registering the aspect as a Spring bean
public class ValidationAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    // Define the pointcut expression and advice method
    @Around("execution(* com.raksh.Spring_Boot_Rest.service.JobService.getJobById(..)) && args(postId)")
    public Object validateInput(ProceedingJoinPoint jp, int postId) throws Throwable {

        // Log and modify the postId if it is negative
        if (postId < 0) {
            LOGGER.info("Received postId is negative: " + postId);
            postId = -postId;  // Updating it to positive
            LOGGER.info("Updated postId to positive: " + postId);
        }

        // Proceed with the modified argument
        Object obj = jp.proceed(new Object[]{postId});

        return obj;
    }
}
