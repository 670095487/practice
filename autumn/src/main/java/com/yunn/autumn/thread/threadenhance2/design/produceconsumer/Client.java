package com.yunn.autumn.thread.threadenhance2.design.produceconsumer;

/**
 * Client
 *
 * @author: yunN
 * @createTime: 2021/01/18
 * @description:
 */
public class Client {

    public static void main(String[] args) {
        final MessageQueue messageQueue = new MessageQueue();
        new ProducerThread(messageQueue, 1).start();
        new ProducerThread(messageQueue, 2).start();
        new ProducerThread(messageQueue, 3).start();
        new ConsumerThread(messageQueue, 1).start();
        new ConsumerThread(messageQueue, 2).start();
    }
}
