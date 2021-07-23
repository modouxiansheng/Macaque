package com.unit.test.service;

import org.springframework.stereotype.Service;

/**
 * @program: unit-test
 * @description:
 * @author: hu_pf
 * @create: 2021-07-15 10:56
 **/
@Service
public class PrivateService {

    public String getPrivateString(){
        return getString();
    }

    private String getString(){
        return "getString";
    }
}
