package com.yunn.autumn.thread.threadenhance3.juc.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * ExecutorService5
 *
 * @author: yunN
 * @createTime: 2021/02/06 14:17:26
 * @description:
 */
public class ExecutorService5 {

    public static void main(String[] args) {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

        // executorService.execute(()-> System.out.println("t1"));
        executorService.getQueue().add(() -> System.out.println("queue bye add"));
    }
}
