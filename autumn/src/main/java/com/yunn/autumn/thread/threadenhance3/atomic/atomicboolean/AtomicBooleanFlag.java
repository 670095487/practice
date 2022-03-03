package com.yunn.autumn.thread.threadenhance3.atomic.atomicboolean;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * AtomicBooleanFlag
 *
 * @author: yunN
 * @createTime: 2021/01/28 15:08:49
 * @description:
 */
public class AtomicBooleanFlag {

    private final static AtomicBoolean flag = new AtomicBoolean(true);

    public static void main(String[] args) throws InterruptedException {
        new Thread(){
            @Override
            public void run() {
                while (flag.get()) {
                    try {
                        Thread.sleep(1000);
                        System.out.println("working ...");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("done ...");
            }
        }.start();

        Thread.sleep(5000);

        flag.set(false);

    }
}
