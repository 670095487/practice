package com.yunn.autumn.leetcode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yunN on 2021/04/19.
 */
public class ConditionPractice {

    private final static Lock lock = new ReentrantLock();

    private final static Condition con1 = lock.newCondition();

    private final static Condition con2 = lock.newCondition();

    public static void main(String[] args) {
    }

    private static void printA() {
        lock.lock();
        try {
            con1.wait();
            System.out.println("A");

        } catch (Exception e) {
            //
        } finally {
            lock.unlock();
        }
    }


    private static void printB() {
        lock.lock();
        try {

            System.out.println("B");

        } catch (Exception e) {
            //
        } finally {
            lock.unlock();
            con1.signal();
        }
    }
}
