package com.macaque.pect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: macaque-log
 * @description:
 * @author: hu_pf
 * @create: 2021-03-30 10:36
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAspect {
}
