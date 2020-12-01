
package com.dmh.distributedseata.customer.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {



    @RequestMapping("/invokeCustomer")
    public String invokeCustomer(){

        return "invokeCustomer";
    }
}
