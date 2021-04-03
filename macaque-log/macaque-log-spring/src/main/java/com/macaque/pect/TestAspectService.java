package com.macaque.pect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

/**
 * @program: macaque-log
 * @description:
 * @author: hu_pf
 * @create: 2021-03-30 10:41
 **/
@Service
@Aspect
public class TestAspectService {

    @Around("@annotation(testAspect)")
    public void invoke(ProceedingJoinPoint joinPoint, TestAspect testAspect){

    }
}
