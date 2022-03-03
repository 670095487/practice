package com.yunn.autumn.thread.threadenhance3.juc.executors;

import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * ExecutorsRejectPolicy
 *
 * @author yunN
 * @createTime 2021年02月05日 14:01
 * @description 演示线程池拒绝策略
 */
public class ExecutorsRejectPolicy {

    public static void main(String[] args) throws InterruptedException {

        // testAbortPolicy();

        // testDiscardPolicy();

        testAllowCoreThreadTimeOut();
    }


    private static void testAbortPolicy() throws InterruptedException {
        ExecutorService executorService =
                //核心线程数、最大线程数、保持活跃时间、时间单位、任务队列、生成线程工厂、线程拒绝策略
                new ThreadPoolExecutor(1, 2, 30, TimeUnit.SECONDS,
                        new ArrayBlockingQueue<>(1), Thread::new, new ThreadPoolExecutor.AbortPolicy());
        productThread(executorService);
    }


    private static void testDiscardPolicy() throws InterruptedException {
        ExecutorService executorService =
                //核心线程数、最大线程数、保持活跃时间、时间单位、任务队列、生成线程工厂、线程拒绝策略
                new ThreadPoolExecutor(1, 2, 30, TimeUnit.SECONDS,
                        new ArrayBlockingQueue<>(1), Thread::new, new ThreadPoolExecutor.DiscardPolicy());
        productThread(executorService);
    }

    private static void productThread(ExecutorService executorService) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            executorService.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            TimeUnit.SECONDS.sleep(1);

            executorService.execute(() -> System.out.println("will be rejected!"));
        }
    }

    private static void testAllowCoreThreadTimeOut() {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        executor.setKeepAliveTime(10, TimeUnit.SECONDS);
        //设置核心线程数最少为0
        executor.setCorePoolSize(0);
        //允许核心线程超时自动销毁
        executor.allowCoreThreadTimeOut(true);
        IntStream.range(0, 5).boxed().forEach(integer ->
                executor.execute(() -> {
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }));
    }
}
