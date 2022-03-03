package com.yunn.autumn.thread.threadenhance3.atomic.integer;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInterDetailTest
 *
 * @author: yunN
 * @createTime: 2021/01/27 16:32:55
 * @description:
 */
public class AtomicInterDetailTest {


    public static void main(String[] args) {
        //基础值是10
        AtomicInteger getAndSet = new AtomicInteger(10);
        //+10
        int result = getAndSet.getAndAdd(10);
        System.out.println(result);
        //增长一次+10？
        System.out.println(getAndSet.get());
        System.out.println(getAndSet.get());
    }
}
