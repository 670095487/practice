package com.yunn.autumn.sourcecode.concurrency2;

/**
 * MyThread
 *
 * @author: yunN
 * @createTime: 2020年10月22日 14:36
 * @description:
 */
public class MyThreadTest {

    public static void main(String[] args) {
        Thread thread = new Thread(new MyThread());
        Thread thread2 = new Thread(new MyThread());
        thread.start();
        thread2.start();
    }
}


class MyThread implements Runnable {


    @Override
    public void run() {
        int x = 0;
        while (true) {
            System.out.println("result = " + x++);
            try {
                Thread.sleep((long) Math.random() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (x == 30) {
                break;
            }
        }
    }
}