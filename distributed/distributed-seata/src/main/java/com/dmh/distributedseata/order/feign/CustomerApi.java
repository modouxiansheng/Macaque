package com.dmh.distributedseata.order.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("customer-server")
public interface CustomerApi {

    /**
     * 调用order
     * @return
     */
    @RequestMapping("/invokeCustomer")
    String invokeCustomer();


    @RequestMapping("/init")
    String init();

    @RequestMapping("/query")
    String query();
}
