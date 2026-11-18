package tn.esprit.autoloc.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
    @After("execution(* tn.esprit.autoloc.services.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {

        String methodName = joinPoint.getSignature().getName();

        Object[] params = joinPoint.getArgs();

        log.info("Before - Methode appelée : "  + methodName);

    }
}
