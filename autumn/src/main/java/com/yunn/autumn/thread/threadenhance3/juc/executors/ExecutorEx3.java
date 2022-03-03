package com.yunn.autumn.thread.threadenhance3.juc.executors;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * ExecutorEx3
 *
 * @author yunN
 * @createTime 2021年02月04日 15:51
 * @description
 */
public class ExecutorEx3 {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService pools = Executors.newWorkStealingPool();

        List<Callable<String>> callableList = IntStream.range(0, 120).boxed().map(i ->
                (Callable<String>) () -> {
                    System.out.println("thread " + Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(2);
                    return "task-" + i;
                }
        ).collect(Collectors.toList());

        // List<Future<String>> futures = pools.invokeAll(callableList);

        // System.out.println("futures" + futures);

        pools.invokeAll(callableList).stream().map(future -> {
            try {
                return future.get();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).forEach(System.out::println);
    }

    @Test
    public void test1() {

    }
}
