package com.macaque.service;


/**
 * @program: distributed-link-tracking
 * @description:
 * @author: hu_pf
 * @create: 2021-05-31 21:56
 **/
public class TestAgent {

    public static void main(String[] args) {
        System.out.println(print("xxx",0));;

        System.out.println(print("print"));


        System.out.println(print("print3",1,"test3"));
    }

    private static String print(String str,Integer count){
        System.out.println(count);
        return str;
    }

    private static String print(String str){
        return str;
    }

    private static String print(String str,Integer count,String test){

        System.out.println(test);
        return str;
    }

}
