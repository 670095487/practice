package com.yunn.interview.thread;

import java.util.concurrent.TimeUnit;

/**
 * SummaryOfThreadJoin
 *
 * @author yunN
 * @createTime 2021年01月28日 21:14
 * @description join方法的总结
 */
public class SummaryOfThreadJoin {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "start ...");
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "join-1");
        t1.join();
        t1.start();
    }
}
