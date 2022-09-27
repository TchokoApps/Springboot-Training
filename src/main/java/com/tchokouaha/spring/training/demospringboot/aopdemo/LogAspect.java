package com.tchokouaha.spring.training.demospringboot.aopdemo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    @Around("@annotation(LogStuff)")
    public Object logSomething(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("Start time: " + start);
        Object proceed = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("End time: " + end);
        long duration = end - start;
        System.out.println("Executation time " + duration + " ms");
        return proceed;
    }

    @Before("@annotation(LogStuff)")
    public Object logMethodName(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature() + " was called");
        return joinPoint;
    }

    @AfterThrowing(value = "@annotation(LogStuff)", throwing = "e")
    public void logException(JoinPoint joinPoint, Exception e) {
        System.out.println(joinPoint.getSignature() + " was called");
        System.out.println(joinPoint.getClass() + " was called");
    }
}
