package com.yunn.autumn.thread.threadenhance3.juc;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * ExchangerEx2
 *
 * @author: yunN
 * @createTime: 2021/02/01 18:41:18
 * @description:
 *
 *
 * 可以用于协程之间共同操作同一组数据。
 */
public class ExchangerEx2 {

    public static void main(String[] args) {
        Exchanger<Integer> exchanger = new Exchanger<>();

        new Thread(() -> {
            AtomicReference<Integer> value
                    = new AtomicReference<>(1);
            try {
                while (true) {
                    value.set(exchanger.exchange(value.get()));
                    System.out.println("thread A get value = " + value.get());
                    TimeUnit.SECONDS.sleep(3);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            AtomicReference<Integer> value
                    = new AtomicReference<>(2);
            try {
                while (true) {
                    value.set(exchanger.exchange(value.get()));
                    System.out.println("thread B get value = " + value.get());
                    TimeUnit.SECONDS.sleep(2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
