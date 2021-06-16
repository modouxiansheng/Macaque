package com.macaque.service.premain;

import java.util.concurrent.TimeUnit;

/**
 * @program: distributed-link-tracking
 * @description:
 * @author: hu_pf
 * @create: 2021-06-16 14:14
 **/
public class PreMainTest {


    public static void main(String[] args) throws InterruptedException {
        while (true) {
            System.out.println(foo());
            TimeUnit.SECONDS.sleep(3);
        }
    }


    public static int foo() {
        return 100; // 修改后 return 50;
    }
}
