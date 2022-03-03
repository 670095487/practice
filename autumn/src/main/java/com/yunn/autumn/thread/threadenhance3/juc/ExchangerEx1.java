package com.yunn.autumn.thread.threadenhance3.juc;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * ExchangerEx1
 *
 * @author: yunN
 * @createTime: 2021/02/01 16:01:29
 * @description:
 *
 * use {@link Exchanger}
 */
public class ExchangerEx1 {


    /*
     * 1.如果同处于一个组的线程 有一个没有发送信息，另一个会进入blocked状态
     */
    public static void main(String[] args) {
        final Exchanger<String> exchanger = new Exchanger<>();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " start.");

            try {
                String result = exchanger.exchange("I am come from T-A");
                System.out.println("get a value from T-B,res = " + result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " end...");

        }, "====A====").start();


        new Thread(() -> {

            System.out.println(Thread.currentThread().getName() + " start.");

            try {
                TimeUnit.SECONDS.sleep(2);
                // String result = exchanger.exchange("I am come from T-B");
                String result = exchanger.exchange("I am come from T-B", 10, TimeUnit.SECONDS);
                System.out.println("get a value from T-A,res = " + result);
            } catch (InterruptedException | TimeoutException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " end...");

        }, "====B====").start();
    }


}
