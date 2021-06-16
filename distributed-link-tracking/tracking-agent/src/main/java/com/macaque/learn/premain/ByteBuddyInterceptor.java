package com.macaque.learn.premain;

import net.bytebuddy.implementation.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/**
 * @program: distributed-link-tracking
 * @description:
 * @author: hu_pf
 * @create: 2021-06-03 17:25
 **/
public class ByteBuddyInterceptor {

//    @RuntimeType
    public Object intercept(@SuperCall Callable<?> origin,
                            @Origin Method method) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("xxxxxx");
        try {
            return origin.call();
        } finally {
            System.out.println(method + " took " + (System.currentTimeMillis() - start));
        }
    }
}
