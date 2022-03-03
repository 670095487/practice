package com.yunn.autumn.thread.threadenhance2.design.countdown;

import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

/**
 * Client
 *
 * @author: yunN
 * @createTime: 2021/01/18 11:41:48
 * @description: 以JDK实现的count-down设计模式为例演示如何使用
 */
public class Client {

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(5);
        System.out.println("多线程任务开始...");
        IntStream.rangeClosed(1, 5).forEach(i -> {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " is working...");
                try {
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName() + " done...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //本线程任务结束后，调用latch，减去本身数目
                latch.countDown();
            }, String.valueOf(i)).start();
        });
        latch.await();
        System.out.println("first phase done...,second phase will begin...");
        System.out.println("second phase done...");
        System.out.println("多线程任务结束...");
    }
}
