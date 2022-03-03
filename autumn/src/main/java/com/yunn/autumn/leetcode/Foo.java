package com.yunn.autumn.leetcode;

import java.util.concurrent.CountDownLatch;

/**
 * Foo
 *
 * @author yunN
 * @createTime 2021年01月18日 21:52
 * @description 多线程--按序打印
 */
public class Foo {

    private boolean isFirstDone = false;

    private boolean isSecondDone = false;

    private final Object LOCK = new Object();

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        synchronized (LOCK) {
            printFirst.run();
            this.isFirstDone = true;
            LOCK.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (LOCK) {
            while (!isFirstDone) {
                LOCK.wait();
                LOCK.notifyAll();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            isSecondDone = true;
            LOCK.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (LOCK) {
            while (!isSecondDone) {
                LOCK.wait();
                LOCK.notifyAll();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            LOCK.notifyAll();
        }
    }
}

/**
 * 使用count-down设计模式实现
 */
class Foo2 {

    private final CountDownLatch c2;

    private final CountDownLatch c3;


    public Foo2() {
        this.c2 = new CountDownLatch(1);
        this.c3 = new CountDownLatch(1);
    }

    /**
     * 此方法最新运行，不需要其他条件，此方法运行结束以后，
     * 将c2的值-1
     */
    public void first(Runnable printFirst) throws InterruptedException {

        printFirst.run();
        c2.countDown();
    }

    /**
     * 等待直到c2被释放出来，即first()执行完毕
     * 然后在本身执行完毕以后释放c3
     */
    public void second(Runnable printSecond) throws InterruptedException {
        c2.await();
        printSecond.run();
        c3.countDown();
    }

    /**
     * 等待直到c3被释放出来，即second()执行完毕
     */
    public void third(Runnable printThird) throws InterruptedException {
        c3.await();
        printThird.run();
    }
}









