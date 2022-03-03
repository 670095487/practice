package com.yunn.interview.thread;

/**
 * SummaryOfDaemonThread
 *
 * @author: yunN
 * @createTime: 2021/01/26 19:08:59
 * @description:
 */
public class SummaryOfDaemonThread {


    public static void main(String[] args) throws InterruptedException {
        Runtime.getRuntime()
                .addShutdownHook(new Thread(()-> System.out.println("JVM EXITS SUCCESS!")));
        Thread th1 = new Thread(()->{
            while (true) {
                try {
                    System.out.println("still running...");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // th1.setDaemon(false);//main线程结束以后，jvm仍旧不会退出，因为此时th1仍旧作为用户线程在工作
        th1.setDaemon(true);//将th1设置为守护线程后，main线程结束以后jvm顺利退出
        th1.start();
        Thread.sleep(2000);
        System.out.println("main will exit..");
    }
}
