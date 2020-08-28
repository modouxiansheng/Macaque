package com.dmh.xa.noxa;

import com.dmh.xa.common.Utils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: guide-dog
 * @description: 分布式事务-XA
 * @author: hu_pf
 * @create: 2020-07-22 12:59
 **/
@SpringBootApplication
public class DistributedTransactionNoXa {

    public static void main(String[] args) {
        Utils.loadPropertySource(DistributedTransactionNoXa.class, "distributed-transaction.properties");
        SpringApplication.run(DistributedTransactionNoXa.class, args);
    }
}
