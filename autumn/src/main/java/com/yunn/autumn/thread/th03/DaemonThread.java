package com.yunn.autumn.thread.th03;

import org.junit.Test;

/**
 * DaemonThread
 *
 * @Author: Bff
 * @CreateTime: 2020-04-21
 * @Description: 创建一个守护线程。
 */
public class DaemonThread {

    /**
     * 应用场景：
     * 用main线程开启一个自定义线程A，在自定义线程中创建一个子线程a，
     * 假设A线程是用来和远端交互的，a线程是用来和远端确认连接的（也就是所谓的心跳确认）
     * 当A线程挂掉了，我要a线程也同步停止，因为当A线程挂掉以后，就没法再和远端进行交互了，
     * 此时a线程没有必要再去做心跳确认了---做法：将a线程设置为守护线程
     */

    public static void main(String[] args) {
        Thread A = new Thread() {
            @Override
            public void run() {
                Thread a = new Thread() {
                    @Override
                    public void run() {
                        try {
                            while (true) {
                                System.out.println("a+++++ start do something ");
                                Thread.sleep(2_000);
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };
                a.setDaemon(true);//如果将a设置为守护线程，那么在A线程启动a后，随着A线程的结束，a也会结束，
                // 这个方法需要在调用start()方法之前调用，否则不生效
                a.start();
                try {
                    System.out.println("A+++ had done ");
                    Thread.sleep(10_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        // A.setDaemon(true);//如果将A设置为守护线程，那么在main线程启动A后，随着main线程的结束，A也会结束
        A.start();
    }


    enum A {
        FUCKYOU
    }

    @Test
    public void test() {
        System.out.println(A.FUCKYOU);
    }
}
