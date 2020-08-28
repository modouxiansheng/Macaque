package com.dmh.distributedmq;


import com.dmh.distributedmq.common.Utils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.XADataSourceAutoConfiguration;

/**
 * @program: guide-dog
 * @description: 分布式事务-MQ 实现最终一致性
 * @author: hu_pf
 * @create: 2020-08-03 11:50
 **/
@SpringBootApplication
public class DistributedTransactionMq {

    public static void main(String[] args) {
        Utils.loadPropertySource(DistributedTransactionMq.class, "distributed-transaction-mq.properties");
        SpringApplication.run(DistributedTransactionMq.class, args);
    }
}
