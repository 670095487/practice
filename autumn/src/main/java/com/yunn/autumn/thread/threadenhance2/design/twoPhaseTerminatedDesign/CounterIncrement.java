package com.yunn.autumn.thread.threadenhance2.design.twoPhaseTerminatedDesign;

import java.util.Random;

/**
 * CounterIncrement
 *
 * @author: yunN
 * @createTime: 2021/01/18 15:36:37
 * @description:
 */
public class CounterIncrement extends Thread {

    private volatile boolean terminated = false;

    private int count = 0;

    private static final Random random = new Random(System.currentTimeMillis());

    @Override
    public void run() {
        try {
            while (!interrupted()) {
                System.out.println("11111- " + Thread.currentThread().getName() + count++);
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            System.out.println("receive a interrupt signal");
            e.printStackTrace();
        } finally {
            this.clean();
        }

    }

    private void clean() {
        System.out.println("22222- " + Thread.currentThread().getName());
    }

    public void close() {
        this.terminated = true;
        this.interrupt();
    }
}

class CounterIncrementClient {

    public static void main(String[] args) throws InterruptedException {
        CounterIncrement counterIncrement = new CounterIncrement();
        counterIncrement.start();
        Thread.sleep(10000);
        counterIncrement.close();
    }
}