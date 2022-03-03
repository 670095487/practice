package com.yunn.autumn.thread.threadenhance3.juc.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ExecutorEx1
 *
 * @author yunN
 * @createTime 2021年02月03日 19:15
 * @description
 */
public class ExecutorEx1 {

    public static void main(String[] args) throws InterruptedException {
        final ExecutorService pools = Executors.newFixedThreadPool(10);
        // new ThreadPoolExecutor()

        pools.submit(() -> System.out.println(Thread.currentThread().getName()));

        pools.execute(() -> System.out.println(Thread.currentThread().getName()));

        pools.execute(() -> System.out.println(Thread.currentThread().getName()));

        pools.execute(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("wait 1 sec ... , then completed ~!");
        });
        pools.shutdown();

        //线程在最大等待时间前结束，返回true ,超时未完成返回false
        boolean b = pools.awaitTermination(2000, TimeUnit.MILLISECONDS);
        System.out.println("awaitTermination = " + b);

        // List<Runnable> runnableList = pools.shutdownNow();
        // System.out.println("runnableList = "+runnableList);

        //会等线程池中所有线程都处于空闲状态后才销毁线程池
        // pools.shutdown();

        System.out.println("===========end=============");
    }

}
