package com.yunn.autumn.leetcode;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yunN on 2021/04/19.
 */
 public class Print {

    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();
    private int number = 1;

    public void printA() {
        lock.lock();
        try {
            //1. 判断
            while (number != 1) {
                conditionA.await();
            }

            //2. 打印
            System.out.print(Thread.currentThread().getName());

            //3. 唤醒
            ++number;
            conditionB.signal(); //此处会使 printB()方法中的 conditionB.await()的线程唤醒
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB() {
        lock.lock();
        try {
            //1. 判断
            while (number != 2) {
                conditionB.await();
            }

            //2. 打印
            System.out.print(Thread.currentThread().getName());

            //3. 唤醒
            ++number;
            conditionC.signal(); //此处会使 printC()方法中的 conditionC.await()的程序唤醒
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC() {
        lock.lock();
        try {

            //1. 判断
            while (number != 3) {
                conditionC.await();
            }

            //2. 打印
            System.out.print(Thread.currentThread().getName());
            System.out.println("");

            //3. 唤醒
            number = 1;
            conditionA.signal(); //此处会使 printA()方法中的 conditionA.await()的线程唤醒
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}


class TestABCAlternate2 {


    public static void main(String[] args) {

        Print print = new Print();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(new Random().nextInt(100));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    print.printB();
                }
            }
        }, "B").start();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(new Random().nextInt(300));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    print.printC();
                }
            }
        }, "C").start();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(new Random().nextInt(200));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    print.printA();
                }
            }
        }, "A").start();
    }
}

