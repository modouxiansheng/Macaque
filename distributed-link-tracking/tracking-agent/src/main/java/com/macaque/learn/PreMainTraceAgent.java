package com.macaque.learn;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

/**
 * @program: distributed-link-tracking
 * @description:
 * @author: hu_pf
 * @create: 2021-05-31 21:37
 **/
public class PreMainTraceAgent {

    public static void premain(String agentArgs, Instrumentation instrumentation) {

        instrumentation.addTransformer(new ClassFileTransformer() {
            @Override
            public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {

                return new byte[0];
            }
        });

        System.out.println(agentArgs+"-----");
        System.out.println(instrumentation.getAllLoadedClasses().length);
    }
}
