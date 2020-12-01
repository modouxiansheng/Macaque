package com.dmh.distributedseata.customer;


import com.dmh.distributedseata.common.Utils;
import com.dmh.distributedseata.order.OrderServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: guide-dog
 * @description:
 * @author: hu_pf
 * @create: 2020-08-27 19:53
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CustomerServer {

    public static void main(String[] args) {
        Utils.loadPropertySource(CustomerServer.class, "tcc-customer.properties");
        SpringApplication.run(CustomerServer.class, args);
    }
}
