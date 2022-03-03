package com.yunn.autumn.thread.th03;

import org.junit.Test;

import java.util.Collections;

/**
 * CreateThread
 *
 * @Author: Bff
 * @CreateTime: 2020-04-20
 * @Description:
 */
public class CreateThread {

    public static void main(String[] args) {
        Thread t1 = new Thread();//无实例，只有在调用start方法后才会创建实例
        t1.start();

        System.out.println(Thread.currentThread().getThreadGroup().getName());


    }


    @Test
    public void t1() {
        int[] arr = {1, 2, 3, 4, 5};
        Collections.singletonList(arr).forEach(System.out::println);
    }
}
