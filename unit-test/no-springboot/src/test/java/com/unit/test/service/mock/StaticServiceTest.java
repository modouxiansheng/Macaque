package com.unit.test.service.mock;

import com.unit.test.service.StaticService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * @program: unit-test
 * @description:
 * @author: hu_pf
 * @create: 2021-07-15 10:28
 **/
@RunWith(PowerMockRunner.class)
@PrepareForTest({StaticService.class})
public class StaticServiceTest {


    @Test
    public void getStringTest(){
        mockStatic(StaticService.class);

        when(StaticService.getString()).thenReturn("mock");

        String string = StaticService.getString();

        Assert.assertEquals("mock",string);
    }

}
