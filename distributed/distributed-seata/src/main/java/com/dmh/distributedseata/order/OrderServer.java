package com.dmh.distributedseata.order;


import com.dmh.distributedseata.common.Utils;
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
public class OrderServer {

    public static void main(String[] args) {
        Utils.loadPropertySource(OrderServer.class, "tcc-order.properties");
        Utils.loadPropertySource(OrderServer.class, "file.conf");
        Utils.loadPropertySource(OrderServer.class, "registry.conf");
        SpringApplication.run(OrderServer.class, args);
    }
}
