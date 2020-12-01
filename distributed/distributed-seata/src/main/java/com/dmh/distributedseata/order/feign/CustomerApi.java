package com.dmh.distributedseata.order.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("order-server")
public interface CustomerApi {

    /**
     * 调用order
     * @return
     */
    @RequestMapping("/invokeOrder")
    String invokeCustomer();

}
