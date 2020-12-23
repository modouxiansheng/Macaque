package classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @program: javadevelop
 * @description:
 * @author: hu_pf
 * @create: 2020-12-23 09:57
 **/
public class Test {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        StandardExecutorClassLoader standardExecutorClassLoader = new StandardExecutorClassLoader("jar包存放的路径");
        Class<?> testClassLoader = standardExecutorClassLoader.loadClass("要加载的类");
        Object o = testClassLoader.newInstance();
        Method[] methods = testClassLoader.getMethods();
        Method print = testClassLoader.getMethod("print", String.class);
        print.invoke(o,"hahaha");
//        System.out.println("");
    }
}
