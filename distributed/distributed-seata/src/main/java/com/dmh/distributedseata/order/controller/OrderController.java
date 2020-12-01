package com.dmh.distributedseata.order.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {


    @RequestMapping("/invokeOrder")
    String invokeOrder(){

        return "invokeOrder";
    }
}
