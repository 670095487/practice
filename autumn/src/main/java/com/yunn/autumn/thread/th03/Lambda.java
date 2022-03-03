package com.yunn.autumn.thread.th03;

/**
 * Lamda
 *
 * @Author: Bff
 * @CreateTime: 2020-04-21
 * @Description:
 */
@SuppressWarnings("all")
public class Lambda {

    public static void main(String[] args) {
        Thread A = new Thread(() -> {
            Thread a = new Thread(() -> {
                try {
                    System.out.println("a++ say wanan");
                    Thread.sleep(2_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            a.setDaemon(true);
            a.start();
        });
        A.start();
        try {
            System.out.println("A+++ say wanan");
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
