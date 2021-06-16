package com.macaque.learn.premain;

import net.bytebuddy.ByteBuddy;

import static net.bytebuddy.matcher.ElementMatchers.isAnnotatedWith;

/**
 * @program: distributed-link-tracking
 * @description:
 * @author: hu_pf
 * @create: 2021-06-03 16:44
 **/
public class ByteBuddyTest {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        final ClassLoader classLoader = ByteBuddyTest.class.getClassLoader();
        final String string = new ByteBuddy()
                .subclass(Object.class)
                .make()
                .load(classLoader)
                .getLoaded()
                .newInstance()
                .toString();

        final Object o = new ByteBuddy()
                .subclass(Object.class)
                .make()
                .load(classLoader)
                .getLoaded()
                .newInstance();


        System.out.println(string);
    }
}
