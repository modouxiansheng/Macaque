package com.dmh.distributedseata.eureka;


import com.dmh.distributedseata.common.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.XADataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @program: guide-dog
 * @description:
 * @author: hu_pf
 * @create: 2020-08-27 19:53
 **/
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaServer
@Slf4j
public class EurekaServer {



    public static void main(String[] args) {
        log.info("info  开始 --- -- -- - -- - ---");
        log.debug("debug  开始 --- -- -- - -- - ---");
        Utils.loadPropertySource(EurekaServer.class, "eureka-server.properties");
        SpringApplication.run(EurekaServer.class, args);
    }
}
