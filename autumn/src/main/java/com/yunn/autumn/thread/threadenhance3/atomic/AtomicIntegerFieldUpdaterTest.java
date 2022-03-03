package com.yunn.autumn.thread.threadenhance3.atomic;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * AtomicIntegerFieldUpdaterTest
 *
 * @author: yunN
 * @createTime: 2021/01/28 19:55:28
 * @description:
 */
public class AtomicIntegerFieldUpdaterTest {


    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerFieldUpdater<TestMe> updater
                = AtomicIntegerFieldUpdater.newUpdater(TestMe.class, "i");
        TestMe testMe = new TestMe();
        ExecutorService pool = Executors.newFixedThreadPool(10);
        /*for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                final int MAX  = 20;
                for (int i1 = 0; i1 < MAX; i1++) {
                    int v = updater.getAndIncrement(testMe);
                    System.out.println(Thread.currentThread().getName() + "=> " + v);
                }
            }).start();
        }*/
        pool.execute(()->{
            final int MAX  = 20;
            for (int i1 = 0; i1 < MAX; i1++) {
                int v = updater.getAndIncrement(testMe);
                System.out.println(Thread.currentThread().getName() + "=> " + v);
            }
        });

        TimeUnit.SECONDS.sleep(5);
        pool.shutdown();

    }


    static class TestMe {

        volatile int i;
    }
}
