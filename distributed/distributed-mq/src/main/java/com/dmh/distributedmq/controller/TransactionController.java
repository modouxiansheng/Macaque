package com.dmh.distributedmq.controller;

import com.gd.guidedog.distributed.mq.config.TransactionProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TransactionController {

	@Autowired
	private TransactionProducer transactionProducer;

	private static final String TOPIC_NAME = "transaction_topic";
	
	//http:/localhost:8082//api/v1/sendTransactionMsg?tag=apk&otherParam=1
	/**
	 * 发送事务性消息
	 * @param tag
	 * @param otherParam
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/api/v1/sendTransactionMsg")
	@ResponseBody
	public Object sendTransactionMsg(String tag, String otherParam) throws Exception {
		Message message = new Message(TOPIC_NAME, tag, tag + "_key", tag.getBytes());
		SendResult sendResult = transactionProducer.getProducer().sendMessageInTransaction(message, otherParam);
		System.out.printf("发送结果=%s, sendResult=%s \n", sendResult.getSendStatus(), sendResult.toString());
		return "发送成功";
	}

}