package com.yunn.autumn.thread.th05;

/**
 * SynchronizedTest
 *
 * @Author: Bff
 * @CreateTime: 2020-05-02
 * @Description: 简单描述 synchronized()关键字的应用方式
 * synchronized 使用范围尽量的小，不然会大幅度影响效率
 * 可使用场景有：代码块，方法
 */
public class SynchronizedTest {

    /*
    定义全局锁
     */
    private static final Object MONITOR = new Object();

    public static void main(String[] args) {
        /*
        方法由并发变为串行，一次只允许一个线程去执行这个方法。
         */
        Runnable runnable = () -> {
            synchronized (MONITOR) {
                try {
                    Thread.sleep(200_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
