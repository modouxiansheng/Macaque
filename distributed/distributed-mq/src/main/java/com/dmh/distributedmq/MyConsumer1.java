package com.dmh.distributedmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @program: springBootPractice
 * @description:
 * @author: hu_pf
 * @create: 2020-04-09 18:44
 **/
@Service
@Slf4j
@RocketMQMessageListener(topic = "test-topic-1", consumerGroup = "my-consumer_test-topic-1")
public class MyConsumer1 implements RocketMQListener<String> {


    @Override
    public void onMessage(String message) {
        log.info("received message: {}", message);
    }
}
