package com.macaque.learn;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;

import static net.bytebuddy.matcher.ElementMatchers.isAnnotatedWith;
import static net.bytebuddy.matcher.ElementMatchers.named;

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
