package com.unit.test.service.mock;

import com.unit.test.service.MockInterface;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.powermock.api.mockito.PowerMockito.when;

/**
 * @program: unit-test
 * @description:
 * @author: hu_pf
 * @create: 2021-07-15 11:24
 **/
@RunWith(PowerMockRunner.class)
public class MockInterfaceTest {

    @Mock
    private MockInterface mockInterface;

    @Test
    public void test(){
        when(mockInterface.getString()).thenReturn("mock");

        String string = mockInterface.getString();

        Assert.assertEquals("mock",string);
    }
}
