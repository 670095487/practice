package com.yunn.autumn.thread.threadenhance2.waitset;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * WaitSetTest
 *
 * @author: yunN
 * @createTime: 2021/01/11
 * @description:
 */
public class WaitSetTest {

    private static final Object LOCK = new Object();

    /**
     * 1.所有的对象都会有一个wait set
     * 2.线程被notify后不一定立即执行
     * 3.线程从wait set中被唤醒的顺序是不确定的 反正不是FIFO
     * 4.线程被notify后需要重新竞争锁，但是不必从头开始执行，而是从wait()代码处争抢锁，然后执行
     *
     * @param args /
     */
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 10).forEach(i ->
                new Thread(String.valueOf(i)) {
                    @Override
                    public void run() {
                        //获取锁
                        synchronized (LOCK) {
                            try {
                                //wait
                                Optional.of("++++++ " + Thread.currentThread().getName() + " 即将陷入waitSet...").ifPresent(System.out::println);
                                LOCK.wait();
                                //被唤醒后执行
                                Optional.of("------ " + Thread.currentThread().getName() + " 即将离开waitSet...").ifPresent(System.out::println);
                            } catch (InterruptedException e) {
                                // e.printStackTrace();
                            }
                        }
                    }
                }.start());

        //使用main线程去唤醒LOCK对象wait set中的线程
        IntStream.rangeClosed(1, 10).forEach(i ->
        {
            synchronized (LOCK) {
                LOCK.notify();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
