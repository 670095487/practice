package com.yunn.autumn.leetcode;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * FooBar
 *
 * @author: yunN
 * @createTime: 2021/01/19 14:57:55
 * @description:
 */
@SuppressWarnings("all")
public class FooBar {


    private int n;

    private final AtomicInteger flag = new AtomicInteger(0);

    private final static ReentrantLock LOCK = new ReentrantLock();

    //等待标识1
    private final Condition con1 = LOCK.newCondition();

    //等待标识2
    private final Condition con2 = LOCK.newCondition();

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            try {
                LOCK.lock();
                if (flag.get() != 0) {
                    con1.await();
                }
                printFoo.run();
                flag.set(1);
                con2.signal();
            } catch (Exception e) {
                //
            } finally {
                LOCK.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            try {
                LOCK.lock();
                if (flag.get() != 1) {
                    con2.await();
                }
                printBar.run();
                flag.set(0);
                con1.signal();
            } catch (Exception e) {
                //
            } finally {
                LOCK.unlock();
            }
        }
    }
}

class FootBar2 {

    //引用型变量被final修饰，不可变的是其地址值，本身值还是可以被改变
    private static final AtomicInteger flag = new AtomicInteger(0);

    public FootBar2(int n) {
    }

    public static void main(String[] args) {
        t1();
    }

    public static void t1() {
        //地址不可变，但是值可变
        flag.set(23);
        System.out.println(flag.get());
    }
}