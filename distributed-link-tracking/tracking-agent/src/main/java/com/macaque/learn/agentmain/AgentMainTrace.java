package com.macaque.learn.agentmain;

import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.commons.AdviceAdapter;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.security.ProtectionDomain;

import static net.bytebuddy.jar.asm.Opcodes.ASM7;

/**
 * @program: distributed-link-tracking
 * @description:
 * @author: hu_pf
 * @create: 2021-06-15 23:41
 **/
public class AgentMainTrace {

    public static void agentmain (String agentArgs, Instrumentation inst) throws UnmodifiableClassException {



        System.out.println("premain load Class2:" + agentArgs);

        new AgentBuilder.Default()
                .type(ElementMatchers.named("TestAgent"))
                .transform(new AgentBuilder.Transformer() {
                    @Override
                    public DynamicType.Builder<?> transform(DynamicType.Builder<?> arg0, TypeDescription arg1,
                                                            ClassLoader arg2, JavaModule arg3) {
                        System.out.println("xxxxx");

                        return arg0.method(ElementMatchers.named("foo"))
                                .intercept(FixedValue.value(50));
                    }

                }).installOn(inst);
        
    }

}
