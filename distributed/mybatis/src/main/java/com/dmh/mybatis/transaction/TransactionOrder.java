package com.dmh.mybatis.transaction;

import com.dmh.mybatis.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @program: distributed
 * @description:
 * @author: hu_pf
 * @create: 2020-12-30 12:54
 **/
@Service
public class TransactionOrder {


    @Resource
    private OrderMapper orderMapper;

    @Autowired
    private TransactionOrder2 transactionOrder2;

    @Transactional
    public void updateOrder(){
        orderMapper.updateOrder();
        transactionOrder2.updateOrder2();
        System.out.println("1");
    }

}
