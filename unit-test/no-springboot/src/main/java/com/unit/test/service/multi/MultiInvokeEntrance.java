package com.unit.test.service.multi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: unit-test
 * @description: 多次调用的入口类
 * @author: hu_pf
 * @create: 2021-07-15 11:29
 **/
@Service
public class MultiInvokeEntrance {

    @Autowired
    private MultiInvokeClassA multiInvokeClassA;

    @Autowired(required = false)
    private MultiInvokeInterfaceService multiInvokeInterfaceService;

    public String invokeEntrance(){

        if (MultiInvokeStaticService.getStatus()){
            return multiInvokeClassA.invokeMethodA();
        }else {
            return multiInvokeInterfaceService.invokeInterface();
        }

    }
}
