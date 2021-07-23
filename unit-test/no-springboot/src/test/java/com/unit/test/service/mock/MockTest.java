package com.unit.test.service.mock;

import com.unit.test.service.TestMockService;
import com.unit.test.service.UnitService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Field;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @program: unit-test
 * @description:
 * @author: hu_pf
 * @create: 2021-07-14 12:48
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-config.xml"})
public class MockTest {

    @Autowired
    @InjectMocks
    private UnitService unitService;

    @Mock
    private TestMockService testMockService;

    @Before
    public void before() throws Exception{
        testMockService = mock(TestMockService.class);
        System.out.println("1");
        Class<? extends UnitService> aClass = unitService.getClass();
        Field testMockServiceField = aClass.getDeclaredField("testMockService");
        testMockServiceField.setAccessible(true);
        testMockServiceField.set(unitService,testMockService);
    }

    @Test
    public void test(){
        when(testMockService.test()).thenReturn("mock");

         String string = unitService.getString();
        System.out.println(string);
    }
}
