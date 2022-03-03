package com.yunn.autumn.thread.threadenhance2.design.threadobserver;

import java.util.Arrays;

/**
 * ThreadLifeCycleClient
 *
 * @author: yunN
 * @createTime: 2021/01/13
 * @description: 测试类
 */
public class ThreadLifeCycleClient {

    public static void main(String[] args) {
        new ThreadLifeCycleObserver().concurrentQuery(Arrays.asList("无敌1","无敌2"));
    }
}
