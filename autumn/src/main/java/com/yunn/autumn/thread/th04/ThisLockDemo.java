package com.yunn.autumn.thread.th04;

/**
 * ThisLockDemo
 *
 * @Author: Bff
 * @CreateTime: 2020-05-04
 * @Description: 讲述关于this锁的使用
 */
public class ThisLockDemo {


    public synchronized void m1() {
        new Thread() {
            @Override
            public void run() {
                System.out.println("m1 start^^^^^");
            }
        };
    }

    public void m2() {
        new Thread() {
            @Override
            public void run() {
                System.out.println("m1 start^^^^^");
            }
        };
    }
}
