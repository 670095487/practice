package com.yunn.autumn.thread.th04;

import java.util.Optional;

/**
 * ThreadSimpleApi
 *
 * @Author: Bff
 * @CreateTime: 2020-04-23
 * @Description: 关于线程的一些简单的api
 */
public class ThreadSimpleApi {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            Optional.of("hello").ifPresent(System.out::println);
        }, "t1");
        /*
            线程的属性：名字 ID 优先级
         */
        Optional.of(t1.getName()).ifPresent(System.out::println);
        Optional.of(t1.getId()).ifPresent(System.out::println);
        Optional.of(t1.getPriority()).ifPresent(System.out::println);
    }
}
