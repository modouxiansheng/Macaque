package com.unit.test.service.mock;

import com.unit.test.service.MultiReturnValueService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Matchers.any;
import static org.powermock.api.mockito.PowerMockito.doAnswer;

/**
 * @program: unit-test
 * @description:
 * @author: hu_pf
 * @create: 2021-07-15 11:09
 **/
@RunWith(PowerMockRunner.class)
public class MultiReturnValueServiceTest {
    @Mock
    private MultiReturnValueService multiReturnValueService;
    @Test
    public void multiReturnValueTest(){
        doAnswer(new Answer<Object>() {
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object[] arguments = invocationOnMock.getArguments();
                Integer integers = (Integer) arguments[0];
                if (integers.equals(1)){
                    return "一:Mock";
                }
                // 执行真正的逻辑方法
                return invocationOnMock.callRealMethod();
            }
        }).when(multiReturnValueService).multiReturn(any(Integer.class));

        String s = multiReturnValueService.multiReturn(1);

        System.out.println(s);
    }
}
