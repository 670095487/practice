package com.yunn.autumn.thread.th06;

/**
 * ProduceConsumerVersion1
 *
 * @Author: Bff
 * @CreateTime: 2020-05-05
 * @Description: 模拟生产者-消费者模型1
 * 缺陷：生产者生产数据没有告诉消费者，导致生产的数据过多，且消费者来不及消费，导致消费者消费的数据
 * 都是最新的，且存在重复消费某一数据的情况
 */
public class ProduceConsumerVersion1 {

    /**
     * 定义锁
     */
    private static final Object lock = new Object();

    private int i = 0;

    public void produce() {
        synchronized (lock) {
            System.out.println("生产者在生产数据" + (i++));
        }
    }

    public void consumer() {
        synchronized (lock) {
            System.out.println("消费者在消费数据" + i);
        }
    }

    /**
     * main
     *
     * @param args
     */
    public static void main(String[] args) {
        ProduceConsumerVersion1 pc = new ProduceConsumerVersion1();
        new Thread("P") {
            @Override
            public void run() {
                while (true) {
                    pc.produce();
                }
            }
        }.start();

        new Thread("C") {
            @Override
            public void run() {
                while (true) {

                    pc.consumer();
                }
            }
        }.start();
    }
}
