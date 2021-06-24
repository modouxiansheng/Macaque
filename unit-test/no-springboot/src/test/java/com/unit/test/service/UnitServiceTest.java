package com.unit.test.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @program: unit-test
 * @description:
 * @author: hu_pf
 * @create: 2021-06-24 15:10
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-config.xml"})
public class UnitServiceTest {


    @Autowired
    private UnitService unitService;


    @Test
    public void getStringTest(){
        final String string = unitService.getString();

        Assert.assertEquals("test",string);
    }

    @Test
    public void getStringErrorTest(){
        final String string = unitService.getString();

        Assert.assertEquals("test1",string);
    }
}
