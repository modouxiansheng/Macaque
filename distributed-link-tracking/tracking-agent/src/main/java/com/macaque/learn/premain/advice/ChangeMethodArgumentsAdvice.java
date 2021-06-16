package com.macaque.learn.premain.advice;

import net.bytebuddy.asm.Advice;

/**
 * @program: distributed-link-tracking
 * @description: 改变入参参数的增强类
 * @author: hu_pf
 * @create: 2021-06-16 08:42
 **/
public class ChangeMethodArgumentsAdvice {


    @Advice.OnMethodEnter
    static void onEnter(
            @Advice.Argument(
                    value = 1,
                    readOnly = false
            )Integer count,
            @Advice.Argument(
                    value = 0,
                    readOnly = false
            )String print
    ){

        count = count + 100;
        print = print + " test";
    }
}
