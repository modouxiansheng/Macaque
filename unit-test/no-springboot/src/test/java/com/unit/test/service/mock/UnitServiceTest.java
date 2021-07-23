package com.unit.test.service.mock;

import com.unit.test.service.UnitService;
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
 * @create: 2021-07-13 21:49
 **/
@RunWith(PowerMockRunner.class)
//@PrepareForTest(fullyQualifiedNames = "com.unit.test..*")
public class UnitServiceTest {

    @Mock
    private UnitService unitService;

    @Test
    public void get(){
        when(unitService.getString()).thenReturn("mock");

        final String string = unitService.getString();

        Assert.assertEquals("mock",string);
    }

}
