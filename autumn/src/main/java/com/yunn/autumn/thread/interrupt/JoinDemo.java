package com.yunn.autumn.thread.interrupt;

/**
 * JoinDemo
 *
 * @author: yunN
 * @createTime: 2021/01/04
 * @description: 演示thread.join() https://www.jianshu.com/p/fc51be7e5bc0
 */
public class JoinDemo extends Thread {
    int i;
    Thread previousThread; //上一个线程

    public JoinDemo(Thread previousThread, int i) {
        this.previousThread = previousThread;
        this.i = i;
    }

    @Override
    public void run() {
        try {
            //主线程调用上一个线程的join方法,发起阻塞的是main线程
            previousThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("num:" + i);
    }

    /**
     * thread.join的含义是当前线程需要等待previousThread线程终止之后才从thread.join返回。
     * 简单来说，就是线程没有执行完之前，会一直阻塞在join方法处。
     */
    public static void main(String[] args) {
        Thread previousThread = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            JoinDemo joinDemo = new JoinDemo(previousThread, i);
            joinDemo.start();
            previousThread = joinDemo;
        }
    }
}
