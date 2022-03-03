package com.yunn.autumn.thread.th06;

import java.util.stream.Stream;

/**
 * ProduceConsumerVersion3
 *
 * @Author: Bff
 * @CreateTime: 2020-05-05
 * @Description: 模型3
 * 改进：将notify()-->notifyAll()
 * 将生产者/消费者的方法中对是否生产的标志判断由if-->while
 */
@SuppressWarnings("all")
public class ProduceConsumerVersion3 {
    /*
  定义锁
   */
    private static final Object lock = new Object();

    private int i = 0;

    /*
    定义变量标志是否已经生产
     */
    private volatile boolean flag = false;

    /*
    生产者
     */
    public void produce() {
        synchronized (lock) {
            /*
              这个判断条件如果用if，那么会出现重复消费/生产的情况，因为用if，当所有的线程都被唤醒的时候，
              这些线程都是处于wait后面的逻辑，不会再次判断是否有数据了，对于生产者来说就会再次生产数据覆盖，
              前一个线程生产的数据，而对于消费者来说就会重复发起消费。
             */
            while (!flag) {
                i++;
                System.out.println("P->" + (i));
                flag = true;
                lock.notifyAll();
            }
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    /*
    消费者
     */
    public void consumer() {
        synchronized (lock) {
            while (flag) {
                System.out.println("C->" + i);
                flag = false;
                lock.notifyAll();
            }
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 在多线程的情况下，消费者线程唤醒的可能是消费者线程，这就可能造成所有的线程都处于wait的状态
     * 举例如下：
     * P生产 唤醒c
     * C消费 唤醒p
     * P生产 唤醒c
     * C消费 唤醒c2
     * C2 这个时候虽然被唤醒了 但是此时没有数据可以消费，于是c2又自行进入到了wait()状态，
     * 所以这个时候，所有的线程均处于wait()状态，去等待其他线程唤醒
     *
     * @param args
     */
    public static void main(String[] args) {
        ProduceConsumerVersion3 pc = new ProduceConsumerVersion3();
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
