package com.yunn.autumn.thread.threadenhance3.juc;

import java.util.concurrent.TimeUnit;

/**
 * ComBetweenThreads
 *
 * @author yunN
 * @createTime 2021年02月02日 15:30
 * @description 线程间通讯-使用sync做生产者-消费者。
 */
public class ComBetweenThreads {
    private static int data = 0;

    /**
     * 初始 false代表 无可用数据
     */
    private static boolean noUse = false;

    private static final Object MONITOR = new Object();

    public static void main(String[] args) {
        new Thread(()->{
            while (true) {
                buildData();
            }
        }).start();

        new Thread(()->{
            while (true) {
                useData();
            }
        }).start();
    }


    /**
     * 生产者
     */
    private static void buildData() {
        synchronized (MONITOR) {
            //true 有可用数据时，生产者线程陷入等待
            while (noUse) {
                try {
                    MONITOR.wait();
                    System.out.println("P -> " + Thread.currentThread().getName() + " ,data=" + data);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            sleep(2);
            data++;
            noUse = true;
            MONITOR.notifyAll();
        }
    }

    /**
     * 消费者
     */
    public static void useData() {
        synchronized (MONITOR) {
            //false 无可用数据时，消费者线程陷入等待
            while (!noUse) {
                try {
                    System.out.println("C -> " + Thread.currentThread().getName() + " ,data=" + data);
                    //调用wait方法，释放锁
                    MONITOR.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            sleep(2);
            noUse = false;
            MONITOR.notifyAll();
        }
    }

    public static void sleep(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
