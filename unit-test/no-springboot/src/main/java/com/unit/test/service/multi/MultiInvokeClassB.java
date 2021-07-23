package com.unit.test.service.multi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: unit-test
 * @description:
 * @author: hu_pf
 * @create: 2021-07-15 14:07
 **/
@Service
public class MultiInvokeClassB {

    @Autowired
    private MultiInvokeCLassC multiInvokeCLassC;

    public String invokeMethodB(){

        return multiInvokeCLassC.invokeMethodC();
    }
}
