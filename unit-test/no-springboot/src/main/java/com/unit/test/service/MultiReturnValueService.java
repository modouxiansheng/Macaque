package com.unit.test.service;

import org.springframework.stereotype.Service;

/**
 * @program: unit-test
 * @description: 多返回值
 * @author: hu_pf
 * @create: 2021-07-15 11:05
 **/
@Service
public class MultiReturnValueService {
    public String multiReturn(Integer key){
        if (key.equals(1)){
            return "一";
        }else if (key.equals(2)){
            return "二";
        }else if (key.equals(3)){
            return "三";
        }
        return "无";
    }
}
