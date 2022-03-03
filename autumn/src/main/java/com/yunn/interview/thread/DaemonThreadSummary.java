package com.yunn.interview.thread;

/**
 * DaemonThreadSummary
 *
 * @author yunN
 * @createTime 2021年01月26日 18:55
 * @description 守护线程总结
 */
public class DaemonThreadSummary {
    public static void main(String[] args) {
        Thread.currentThread().setDaemon(false);
        SubThread subThread = new SubThread();
        Thread daemon = new Thread(
                () ->
                        System.out.println(Thread.currentThread().getName()),
                "daemon-thread");
        subThread.start();
        daemon.setDaemon(true);
        daemon.start();
    }
}

class SubThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " starting ...");
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}
