package com.unit.test.service.mock;

import com.unit.test.service.PrivateService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * @program: unit-test
 * @description:
 * @author: hu_pf
 * @create: 2021-07-15 10:57
 **/
@RunWith(PowerMockRunner.class)
@PrepareForTest({PrivateService.class})
public class PrivateServiceTest {
    @Test
    public void testGetString() throws Exception {

        PrivateService p = spy(new PrivateService());

        when(p,"getString").thenReturn("mock");

        String privateString = p.getPrivateString();

        Assert.assertEquals("mock",privateString);
    }
}
