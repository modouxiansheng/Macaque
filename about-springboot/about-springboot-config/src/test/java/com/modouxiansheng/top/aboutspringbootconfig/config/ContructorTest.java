package com.modouxiansheng.top.aboutspringbootconfig.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @program: about-springboot
 * @description:
 * @author: hu_pf
 * @create: 2022-05-30 09:01
 **/
@SpringBootTest
public class ContructorTest {

    @Autowired
    private ConstructorBindingData constructorBindingData;

    @Test
    public void test(){
        System.out.printf(constructorBindingData.toString());
    }
}
