package com.macaque.log.test;

/**
 * @program: macaque-log
 * @description:
 * @author: hu_pf
 * @create: 2021-03-10 21:44
 **/
public class TestMain {

    public static void main(String[] args) {
        TestInterfaceImpl testInterface = new TestInterfaceImpl();
        String str = testInterface.get();

        TestInterfaceInt interfaceInt = new TestInterfaceInt();
        Integer integer = interfaceInt.get();

        System.out.println(str);
    }
}
