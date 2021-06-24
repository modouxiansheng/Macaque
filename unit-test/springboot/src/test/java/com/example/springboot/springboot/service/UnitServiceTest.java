package com.example.springboot.springboot.service;

import com.example.springboot.springboot.CommonTest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: unit-test
 * @description:
 * @author: hu_pf
 * @create: 2021-06-24 17:24
 **/
public class UnitServiceTest extends CommonTest {

    @Autowired
    private UnitService unitService;

    @Test
    public void getTextTest(){

        final String text = unitService.getText();

        Assert.assertEquals("hello",text);
    }

    @Test
    public void getTextTestError(){

        final String text = unitService.getText();

        Assert.assertEquals("hello1",text);
    }
}
