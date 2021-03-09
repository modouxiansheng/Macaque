
package com.dmh.distributedseata.customer.controller;


import com.dmh.distributedseata.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/index")
    public String index(){
        return "hello";
    }

    @RequestMapping("/invokeCustomer")
    public String invokeCustomer(){
        customerService.invoke();
        return "invokeCustomer";
    }


    @RequestMapping("/init")
    String init(){
        customerService.init();
        return "1";
    }

    @RequestMapping("/query")
    String query(){
        return customerService.query();
    }
}
