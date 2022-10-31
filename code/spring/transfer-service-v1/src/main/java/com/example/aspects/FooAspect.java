package com.example.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class FooAspect {

    private static final Logger log = LoggerFactory.getLogger(FooAspect.class);

//    @Before(value = "execution(* *(..))")
//    public void before(JoinPoint joinPoint) {
//        log.info("before : "+joinPoint.toShortString() +" \t "+ Arrays.toString(joinPoint.getArgs()));
//    }

//    @AfterReturning(value = "execution(* transfer(..))",returning = "r")
//    public void afterReturning(JoinPoint joinPoint,Object r) {
//        log.info("afterReturning : "+r);
//    }

//    @AfterThrowing(value = "execution(* transfer(..))", throwing = "e")
//    public void afterThrowing(JoinPoint joinPoint, Throwable e) {
//        log.info("afterThrowing : " + e.getMessage());
//    }

//    @After("execution(* transfer(..))")
//    public void afterThrowing(JoinPoint joinPoint) {
//        log.info("after");
//    }

    @Around(value = "execution(* transfer(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            log.info("before : " + joinPoint.toShortString() + " \t " + Arrays.toString(joinPoint.getArgs()));
            joinPoint.proceed();
            log.info("afterRetuning");
        } catch (Throwable e) {
            log.info("afterThrowing : " + e.getMessage());
            throw e;
        } finally {
            log.info("after");
        }
        return null;
    }

}
