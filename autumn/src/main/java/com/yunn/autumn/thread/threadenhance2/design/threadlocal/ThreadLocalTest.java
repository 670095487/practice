package com.yunn.autumn.thread.threadenhance2.design.threadlocal;

/**
 * ThreadLocalTest
 *
 * @author: yunN
 * @createTime: 2021/01/16
 * @description:
 */
@SuppressWarnings("all")
public class ThreadLocalTest {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return "yunN";
        }
    };

    public static void main(String[] args) {

        new Thread(() -> {
            // threadLocal.set("yunN=>" + Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName() + " ---> " + threadLocal.get());
        }).start();
        threadLocal.set("yunN=>" + Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName() + " ---> " + threadLocal.get());
    }
}
