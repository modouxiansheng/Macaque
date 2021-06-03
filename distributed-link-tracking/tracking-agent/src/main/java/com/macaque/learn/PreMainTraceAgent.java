package com.macaque.learn;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.SuperMethodCall;
import net.bytebuddy.implementation.bind.annotation.*;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.lang.reflect.Method;
import java.security.ProtectionDomain;
import java.util.concurrent.Callable;

import static net.bytebuddy.matcher.ElementMatchers.named;

/**
 * @program: distributed-link-tracking
 * @description:
 * @author: hu_pf
 * @create: 2021-05-31 21:37
 **/
public class PreMainTraceAgent {

    public static void premain(String agentArgs, Instrumentation instrumentation) {

        System.out.println("start premain");
        new AgentBuilder.Default()
                .type(named("com.macaque.service.TestAgent"))
                .transform((builder, typeDescription, classLoader,javaModule) ->
                        builder.method(named("print"))
                        .intercept(MethodDelegation.to(new Interceptor()))
                ).
                installOn(instrumentation);
        new AgentBuilder.Default()
                .type(named("com.macaque.service.TestAgent"))
                .transform((builder, typeDescription, classLoader,javaModule) ->
                        builder.method(named("print"))
                                .intercept(MethodDelegation.to(new Interceptor()))
                ).
                installOn(instrumentation);
        // MemberSubstitution

//        instrumentation.addTransformer(new ClassFileTransformer() {
//            @Override
//            public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
//                if ("com/macaque/service/TestAgent".equals(className)){
//                    System.out.println(className);
//                }
//                return new byte[0];
//            }
//        });
    }

    public static class Interceptor{
        @RuntimeType
        public Object intercept(@AllArguments Object[] arguments,
                                @SuperCall Callable<?> origin,
                                @Origin Method method) throws Throwable {
            long start = System.currentTimeMillis();
            arguments[0] = ((String)arguments[0])+"preMain";
            try {
                return origin.call();
            } finally {
                System.out.println(method + " took " + (System.currentTimeMillis() - start));
            }
        }

    }
}


