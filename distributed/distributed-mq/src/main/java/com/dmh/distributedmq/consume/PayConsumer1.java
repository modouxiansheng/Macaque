package com.dmh.distributedmq.consume;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PayConsumer1 {

	private DefaultMQPushConsumer consumer;

	private String consumerGroup = "transac_consumer_group";

	public PayConsumer1() throws MQClientException {

		consumer = new DefaultMQPushConsumer(consumerGroup);
		consumer.setNamesrvAddr("localhost:9876");
		consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
		// 默认是集群方式，可以更改为广播，但是广播方式不支持重试
		consumer.setMessageModel(MessageModel.CLUSTERING);
		consumer.subscribe("transaction_topic", "*");
		consumer.registerMessageListener(new MessageListenerConcurrently() {

			@Override
			public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
				MessageExt msg = msgs.get(0);
				String key = msg.getKeys();
				try {

					System.out.printf("%s 2 Receive New Messages: %s %n", Thread.currentThread().getName(),
							new String(msgs.get(0).getBody()));
					return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
				} catch (Exception e) {
					System.out.println("消费异常");
					e.printStackTrace();
					return ConsumeConcurrentlyStatus.RECONSUME_LATER;
				}
			}
		});
		consumer.start();
		System.out.println("consumer start ...");
	}

}
