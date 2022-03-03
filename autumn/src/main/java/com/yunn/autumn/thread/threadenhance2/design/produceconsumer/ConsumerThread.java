package com.yunn.autumn.thread.threadenhance2.design.produceconsumer;

import java.util.Random;

/**
 * ConsumerThread
 *
 * @author: yunN
 * @createTime: 2021/01/18
 * @description:
 */
public class ConsumerThread extends Thread{

    private final MessageQueue messageQueue;

    private final static Random RANDOM = new Random(System.currentTimeMillis());

    public ConsumerThread(MessageQueue messageQueue,int seq) {
        super("CONSUMER-" + seq);
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        //模拟消费者行为
        while (true) {
            try {
                Message message = messageQueue.take();
                System.out.println(Thread.currentThread().getName() + " take a message :" + message.getValue());
                Thread.sleep(RANDOM.nextInt(10000));
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
