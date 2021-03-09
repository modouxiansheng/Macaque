package com.dmh.distributedseata.eureka;

import org.springframework.stereotype.Service;

/**
 * @program: distributed
 * @description:
 * @author: hu_pf
 * @create: 2021-03-02 14:11
 **/
@Service
public class TestAbstractTwo extends TestAbstract{

    @Override
    public void realInvoke() {
        System.out.println("Real work!!!!");
    }
}
