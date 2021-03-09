package com.dmh.distributedseata.eureka;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: distributed
 * @description:
 * @author: hu_pf
 * @create: 2021-03-02 14:09
 **/
public abstract class TestAbstract {

    @Autowired
    private TestService testService;

    public void invoke(){

        System.out.println(testService.getData());
        realInvoke();
    }

    public abstract void realInvoke();
}
