package com.yunn.autumn.leetcode;

/**
 * JoinPractice
 *
 * @author yunN
 * @createTime 2021年04月07日 21:09
 * @description
 */
public class JoinPractice {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> System.out.println("1"));
        Thread t2 = new Thread(() -> System.out.println("2"));
        t1.start();
        t1.join();
        t2.start();


    }
}
