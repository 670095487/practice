package com.yunn.interview;

/**
 * WillView
 *
 * @author yunN
 * @createTime 2021年02月11日 14:55
 * @description
 */
public class WillView {

    public static void main(String[] args) {
        SecurityManager manager = System.getSecurityManager();
        System.out.println("========");
        new Thread(() -> System.out.println(Thread.currentThread().getThreadGroup())).start();
    }
}
