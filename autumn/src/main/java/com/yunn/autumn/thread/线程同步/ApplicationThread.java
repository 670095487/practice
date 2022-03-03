package com.yunn.autumn.thread.线程同步;

/**
 * ApplicationTest
 *
 * @author yunnuan
 * @createTime 2020年12月31日 21:28
 * @description
 */
public class ApplicationThread implements Runnable {

    private final Object MONITOR = new Object();

    private int index = 0;

    private final int max = 500;

    @Override
    public void run() {
        while (true) {
            synchronized (MONITOR) {
                System.out.println("yyyyMMdd");
            }

        }
    }

    public static void main(String[] args) {
        ApplicationThread applicationThread = new ApplicationThread();
        applicationThread.run();
    }
}
