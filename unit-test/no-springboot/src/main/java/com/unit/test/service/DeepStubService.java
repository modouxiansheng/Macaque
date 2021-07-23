package com.unit.test.service;

import org.springframework.stereotype.Service;

/**
 * @program: unit-test
 * @description:
 * @author: hu_pf
 * @create: 2021-07-16 15:15
 **/
@Service
public class DeepStubService {
    public DeepStubService getDeepStubService(){

        return new DeepStubService();
    }
    public String testString(){
        return "DeepStubService";
    }
}
