package com.example.springboot.springboot.service;

import com.example.springboot.springboot.CommonTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;
/**
 * @program: unit-test
 * @description:
 * @author: hu_pf
 * @create: 2021-06-24 17:24
 **/
public class UnitServiceTest extends CommonTest {

    @MockBean
    private UnitService unitService;

    @Test
    public void getTextTest(){
        when(unitService.getText()).thenReturn("mock");
        String text = unitService.getText();

        System.out.println(text);
    }

    @Test
    public void getTextTestError(){

        final String text = unitService.getText();

        Assert.assertEquals("hello1",text);
    }

}
