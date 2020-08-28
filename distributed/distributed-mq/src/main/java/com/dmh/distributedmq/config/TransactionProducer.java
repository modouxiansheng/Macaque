package com.dmh.distributedmq.config;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

@Component
public class TransactionProducer {

	private String producerGroup = "trac_producer_group";

	//事务监听器
	private TransactionListener transactionListener = new TransactionListenerImpl();
	
	private TransactionMQProducer producer = null;

	// 一般自定义线程池的时候，需要给线程加个名称
	private ExecutorService executorService = new ThreadPoolExecutor(2, 5, 100, TimeUnit.SECONDS,
			new ArrayBlockingQueue<Runnable>(2000), new ThreadFactory() {
				@Override
				public Thread newThread(Runnable r) {
					Thread thread = new Thread(r);
					thread.setName("client-transaction-msg-check-thread");
					return thread;
				}

			});

	
	public TransactionProducer() {
		producer = new TransactionMQProducer(producerGroup);
		producer.setNamesrvAddr("localhost:9876");
		producer.setTransactionListener(transactionListener);
		producer.setExecutorService(executorService);
		// 指定NameServer地址，多个地址以 ; 隔开

		start();
	}

	public TransactionMQProducer getProducer() {
		return this.producer;
	}

	/**
	 * 对象在使用之前必须要调用一次，只能初始化一次
	 */
	public void start() {
		try {
			this.producer.start();
		} catch (MQClientException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 一般在应用上下文，使用上下文监听器，进行关闭
	 */
	public void shutdown() {
		this.producer.shutdown();
	}

}