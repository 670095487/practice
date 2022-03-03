package com.yunn.autumn.thread.interrupt;

/**
 * ThreadInterrupt
 *
 * @author: yunN
 * @createTime: 2020/12/28
 * @description: 中断
 */
public class ThreadInterrupt {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(100);
                        System.out.println("sleep……");
                    } catch (InterruptedException e) {
                        System.out.println("receive a interrupt signal");
                    }
                }
            }
        };
        t.start();
        Thread.sleep(1000);
        System.out.println(t.isInterrupted());
        t.interrupt();
        System.out.println(t.isInterrupted());
    }

    //()这里传入应该是runnable对象
    Thread t2 = new Thread(() -> {
        while (true) {
            try {
                Thread.sleep(100);
                System.out.println("sleep……");
            } catch (InterruptedException e) {
                System.out.println("receive a interrupt signal");
            }
            //静态方法 #{interrupted()} 的使用之处
            System.out.println(Thread.interrupted());
        }
    });
}
