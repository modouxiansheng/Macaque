package com.example.springboot.springboot.service;

import com.example.springboot.springboot.CommonTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.mockito.Mockito.*;
/**
 * @program: unit-test
 * @description:
 * @author: hu_pf
 * @create: 2021-07-09 11:35
 **/
public class MockTest extends CommonTest {

    @Autowired
    private UnitService unitService;

    @Test
    public void test(){
//        when(unitService.getText()).thenReturn("mnock");

        final String text = unitService.getText();
        System.out.println(text);
    }
}
