package com.dmh.distributedseata.customer;


import com.dmh.distributedseata.common.Utils;
import com.dmh.distributedseata.order.OrderServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @program: guide-dog
 * @description:
 * @author: hu_pf
 * @create: 2020-08-27 19:53
 **/
@SpringBootApplication
public class CustomerServer {

    public static void main(String[] args) {
        Utils.loadPropertySource(CustomerServer.class, "tcc-customer.properties");
        Utils.loadPropertySource(OrderServer.class, "file.conf");
        Utils.loadPropertySource(OrderServer.class, "registry.conf");
        SpringApplication.run(CustomerServer.class, args);
    }
}
