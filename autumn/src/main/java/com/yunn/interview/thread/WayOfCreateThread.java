package com.yunn.interview.thread;

/**
 * WayOfCreateThread
 *
 * @author yunN
 * @createTime 2021年01月25日 21:56
 * @description 创建线程的2种方式
 */
public class WayOfCreateThread {
    public static void main(String[] args) {
        A a = new A();
        //会创建一个新线程
        a.start();
        B b = new B();
        //会在当前线程（main）运行此方法。
        b.run();
    }
}

/**
 * Thread 也实现了 Runnable接口，所以两者在使用方式上没有什么不同。但是由于java只支持单继承，
 * 如果使用了extends方式创建线程，那么意味着会牺牲掉一次扩展其他类的机会。所以，使用implements
 * 方式创建线程更优。
 */
class A extends Thread {
    //可以不实现
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " extends Thread...");
    }
}

class B implements Runnable {
    //必须实现
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " implements Runnable...");
    }
}