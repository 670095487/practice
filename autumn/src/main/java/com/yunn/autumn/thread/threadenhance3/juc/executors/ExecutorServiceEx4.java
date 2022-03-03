package com.yunn.autumn.thread.threadenhance3.juc.executors;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * ExecutorServiceEx4
 *
 * @author: yunN
 * @createTime: 2021/02/06 11:44:03
 * @description:
 */
public class ExecutorServiceEx4 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        testInvokeAny();
    }

    private static void testInvokeAny() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<Callable<Integer>> callableList = IntStream.range(0, 5).boxed().map(
                i -> (Callable<Integer>) () -> {
                    TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(20));
                    System.out.println(Thread.currentThread().getName() +":"+ i);
                    return i;
                }).collect(Collectors.toList());
        // List<Future<Integer>> futures = executorService.invokeAll(callableList);同步
        Integer futures = executorService.invokeAny(callableList);//一个线程返回了以后，后面的线程就不会再执行了
        System.out.println("=================finished======================");
        System.out.println(futures);
    }
}
