package com.dmh.mybatis.transaction;

import com.dmh.mybatis.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @program: distributed
 * @description:
 * @author: hu_pf
 * @create: 2020-12-30 12:58
 **/
@Service
public class TransactionOrder2 {


    @Resource
    private OrderMapper orderMapper;


    @Transactional(propagation = Propagation.NESTED)
    public void updateOrder2(){
        orderMapper.updateOrder2();
//        int i = 1/0;
    }
}
