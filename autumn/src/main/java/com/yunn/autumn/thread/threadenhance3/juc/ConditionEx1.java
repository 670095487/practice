package com.yunn.autumn.thread.threadenhance3.juc;

import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ConditionEx1
 *
 * @author yunN
 * @createTime 2021年02月02日 14:34
 * @description condition详解
 */
public class ConditionEx1 {

    private final static ReentrantLock LOCK = new ReentrantLock();

    private final static Condition CONDITION = LOCK.newCondition();

    private static int DATA = 0;

    private static volatile boolean NO_USE = false;

    /**
     * 生产者
     */
    public static void buildData() {
        try {
            LOCK.lock();
            //如果没有可用的数据，就陷入等待
              while (NO_USE) {
                CONDITION.await();
            }
            //生产数据
            DATA++;
            Optional.of("P:" + DATA).ifPresent(System.out::println);
            TimeUnit.SECONDS.sleep(1);
            NO_USE = true;
            //唤醒正在等待condition的线程
            CONDITION.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            LOCK.unlock();
        }
    }

    /**
     * 消费者
     */
    private static void useData() {
        try {
            LOCK.lock();
            //初始值为false,无可消费数据时为false,此时需要等待。
            while (!NO_USE) {
                CONDITION.await();
            }
            TimeUnit.SECONDS.sleep(1);
            Optional.of("C:" + DATA).ifPresent(System.out::println);
            NO_USE = false;
            CONDITION.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            LOCK.unlock();
        }
    }

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                buildData();
            }
        }).start();

        new Thread(() -> {
            while (true) {
                useData();
            }
        }).start();
    }
}
