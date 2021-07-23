package com.unit.test.service.mock;

import com.unit.test.service.DeepStubService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.when;

/**
 * @program: unit-test
 * @description:
 * @author: hu_pf
 * @create: 2021-07-16 15:16
 **/
@RunWith(PowerMockRunner.class)
public class DeepStubServiceTest {
    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private DeepStubService deepStubService;
    @Test
    public void testStringTest(){
        when(deepStubService.getDeepStubService().testString())
                .thenReturn("mock");
        String string = deepStubService.getDeepStubService().testString();
        Assert.assertEquals("mock",string);
    }
}
