package com.crud.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopAspect {
    private final static Logger LOGGER =LoggerFactory.getLogger(AopAspect.class);
    @Pointcut("execution( * com.crud.service.*.*(..))")
    private void pointcut(){


    }

    @Around("com.crud.aop.AopAspect.pointcut()")
    public Object around(ProceedingJoinPoint pjp){
        long current = System.currentTimeMillis();
        Object proceed =null;

        try {
            proceed = pjp.proceed();
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }
        long end = System.currentTimeMillis();
        LOGGER.info("消耗时间："+(end-current));

        return proceed;
    }


    @Before("com.crud.aop.AopAspect.pointcut()")
    public void before(){
        System.out.println("before");
    }
    @After("com.crud.aop.AopAspect.pointcut()")
    public void after(){

        System.out.println("after");
    }
}
