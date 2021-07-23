package com.unit.test.service.mock.multi;

import com.unit.test.service.multi.MultiInvokeCLassC;
import com.unit.test.service.multi.MultiInvokeEntrance;
import com.unit.test.service.multi.MultiInvokeInterfaceService;
import com.unit.test.service.multi.MultiInvokeRpcInterface;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Field;

import static org.powermock.api.mockito.PowerMockito.*;


/**
 * @program: unit-test
 * @description:
 * @author: hu_pf
 * @create: 2021-07-15 14:15
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-config.xml"})
public class MultiInvokeEntranceTest {

    // 入口类
    @Autowired
    private MultiInvokeEntrance multiInvokeEntrance;

    @Autowired
    private MultiInvokeCLassC multiInvokeCLassC;

    @Before
    public void before() throws Exception {
        MultiInvokeRpcInterface multiInvokeRpcInterface = mock(MultiInvokeRpcInterface.class);
        when(multiInvokeRpcInterface.invokeRpc()).thenReturn("mock11100");

        MultiInvokeInterfaceService multiInvokeInterfaceService = mock(MultiInvokeInterfaceService.class);
        when(multiInvokeInterfaceService.invokeInterface()).thenReturn("mock11");

        replace(multiInvokeEntrance,"multiInvokeInterfaceService",multiInvokeInterfaceService);
        replace(multiInvokeCLassC,"multiInvokeRpcInterface",multiInvokeRpcInterface);
    }

    public <T,U>void replace(T target,String paraName,U paramObject) throws Exception{
        Class aClass = target.getClass();
        Field field = aClass.getDeclaredField(paraName);
        field.setAccessible(true);
        field.set(target,paramObject);
    }

    @Test
    public void test(){
        final String s = multiInvokeEntrance.invokeEntrance();

        System.out.println(s);
    }


}
