package com.yunn.autumn.thread.threadenhance2.design.produceconsumer;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ProducerThread
 *
 * @author: yunN
 * @createTime: 2021/01/18
 * @description:
 */
public class ProducerThread extends Thread{

    private final MessageQueue messageQueue;

    private final static Random RANDOM = new Random(System.currentTimeMillis());

    private final static AtomicInteger COUNTER = new AtomicInteger(0);

    public ProducerThread(MessageQueue messageQueue,int seq) {
        super("PRODUCER-" + seq);
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        //模拟消费者行为
        while (true) {
            try {
                Message message = new Message("Message-" + COUNTER.getAndIncrement());
                messageQueue.put(message);
                System.out.println(Thread.currentThread().getName() + " put message :" + message.getValue());
                Thread.sleep(RANDOM.nextInt(10000));
            } catch (InterruptedException e) {
                break;
            }

        }
    }
}
