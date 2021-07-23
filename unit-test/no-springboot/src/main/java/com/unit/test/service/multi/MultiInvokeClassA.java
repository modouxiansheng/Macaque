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
public class MultiInvokeClassA {

    @Autowired
    private MultiInvokeClassB multiInvokeCLassB;

    public String invokeMethodA(){

        return multiInvokeCLassB.invokeMethodB();
    }
}
