package com.yunn.autumn.thread.th04;

/**
 * ThreadInterrupt
 *
 * @Author: Bff
 * @CreateTime: 2020-05-02
 * @Description: 中断的API使用
 * <p>
 * <p>
 * 静态的isInterrupted 和非静态的 isInterrupted 作用是相同的，只是使用的对象不同
 */
public class ThreadInterrupt {

    private static Object MONITOR = new Object();

    public static void main(String[] args) {

        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (MONITOR) {
                        try {
                            MONITOR.wait(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        t.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t.isInterrupted());
        t.interrupt();
        System.out.println(t.isInterrupted());
    }
}
