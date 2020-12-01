package com.dmh.distributedseata.order.service;

import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

@Service
public class OrderService {


    @GlobalTransactional(name = "order",rollbackFor = Exception.class) //此注解开启全局事务
    public void invoke(){

    }
}
