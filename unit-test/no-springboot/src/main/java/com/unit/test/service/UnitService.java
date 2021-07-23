package com.unit.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: unit-test
 * @description:
 * @author: hu_pf
 * @create: 2021-06-24 15:09
 **/
@Service
public class UnitService {

    @Autowired
    private TestMockService testMockService;

    public String getString(){
        return testMockService.test();
    }

}
