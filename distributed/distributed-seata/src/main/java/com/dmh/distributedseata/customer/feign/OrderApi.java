package com.dmh.distributedseata.customer.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("customer-server")
public interface OrderApi {

    /**
     * 调用order
     * @return
     */
    @RequestMapping("/invokeOrder")
    String invokeOrder();

}
