package com.yunn.autumn.thread.th06;

import java.util.stream.Stream;

/**
 * ProduceConsumerVersion2
 *
 * @Author: Bff
 * @CreateTime: 2020-05-05
 * @Description: 模型2
 * 缺陷：在多线程的情况下，消费者线程唤醒的可能是消费者线程（生产者线程唤醒的情况同理）
 * ，这就可能造成所有的线程都处于wait的状态
 */
public class ProduceConsumerVersion2 {
    /*
   定义锁
    */
    private static final Object lock = new Object();

    private int i = 0;

    /*
    定义变量标志是否已经生产
     */
    private volatile boolean flag = false;

    public void produce() {
        synchronized (lock) {
            if (flag) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                i++;
                System.out.println("P->" + (i));
                flag = true;
                lock.notify();
            }
        }
    }

    public void consumer() {
        synchronized (lock) {
            if (flag) {
                System.out.println("C->" + i);
                flag = false;
                lock.notify();
            } else {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 在多线程的情况下，消费者线程唤醒的可能是消费者线程，这就可能造成所有的线程都处于wait的状态
     *
     * @param args
     */
    public static void main(String[] args) {
        ProduceConsumerVersion2 pc = new ProduceConsumerVersion2();
        Stream.of("P1", "P2").forEach(n ->
                new Thread() {
                    @Override
                    public void run() {
                        while (true)
                            pc.produce();
                    }
                }.start());

        Stream.of("C1", "C2").forEach(n -> new Thread() {
            @Override
            public void run() {
                while (true)
                    pc.consumer();
            }
        }.start());
    }
}
