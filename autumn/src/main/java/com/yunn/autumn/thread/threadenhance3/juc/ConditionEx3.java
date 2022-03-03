package com.yunn.autumn.thread.threadenhance3.juc;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * ConditionEx3
 *
 * @author yunN
 * @createTime 2021年02月02日 15:51
 * @description 多线程:消费者-生产者
 */
public class ConditionEx3 {

    private final static Lock LOCK = new ReentrantLock();

    private final static Condition PRODUCE_COND = LOCK.newCondition();

    private final static Condition CONSUMER_COND = LOCK.newCondition();

    private final static LinkedList<Long> TIMESTAMP_POOL = new LinkedList<>();

    private final static int MAX_CAPACITY = 100;

    public static void main(String[] args) {
        IntStream.rangeClosed(0, 7).forEach(i -> {
            beginProduce(i);
            sleep(1);
        });

        IntStream.rangeClosed(0, 17).forEach(i -> {
            beginConsume(i);
            sleep(3);
        });
    }

    /**
     * 生产者
     */
    public static void producer() {
        try {
            LOCK.lock();
            //如果共享数据池数据量已经超过最大阈值，生产者线程陷入等待
            while (TIMESTAMP_POOL.size() >= MAX_CAPACITY) {
                PRODUCE_COND.await();
            }
            long value = System.currentTimeMillis();
            System.out.println("P->" + Thread.currentThread().getName() + " value= " + value);
            TIMESTAMP_POOL.addLast(value);
            CONSUMER_COND.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            LOCK.unlock();
        }
    }

    /**
     * 消费者
     */
    public static void consumer() {
        try {
            LOCK.lock();
            while (TIMESTAMP_POOL.isEmpty()) {
                CONSUMER_COND.await();
            }
            long res = TIMESTAMP_POOL.removeFirst();
            System.out.println("C->" + Thread.currentThread().getName() + " res= " + res);
            PRODUCE_COND.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            LOCK.unlock();
        }
    }

    public static void beginProduce(int thread_suffix) {
        new Thread(() -> {
            while (true) {
                producer();
                sleep(2);
            }
        }, "P" + thread_suffix).start();
    }


    public static void beginConsume(int thread_suffix) {
        new Thread(() -> {
            while (true) {
                consumer();
                sleep(3);
            }
        }, "C" + thread_suffix).start();
    }

    public static void sleep(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
