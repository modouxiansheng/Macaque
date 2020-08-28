package com.dmh.xa.hasxa;

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
public class DistributedTransactionHasXa {

    public static void main(String[] args) {
        Utils.loadPropertySource(DistributedTransactionHasXa.class, "distributed-transaction.properties");
        SpringApplication.run(DistributedTransactionHasXa.class, args);
    }
}
