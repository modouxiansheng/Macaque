package com.dmh.distributedseata.order.controller;


import com.dmh.distributedseata.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/invokeOrder")
    String invokeOrder(){
        orderService.invoke();
        return "invokeOrder";
    }

    @RequestMapping("/init")
    String initData(){
        orderService.init();
        return "invokeOrder";
    }

    @RequestMapping("/query")
    String query(){
        return orderService.query();
    }
}
