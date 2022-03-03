package com.yunn.autumn.thread.threadenhance3.juc.executors;

import org.junit.Test;

import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * ExecutorEx2
 *
 * @author yunN
 * @createTime 2021年02月04日 14:05
 * @description 使用cachePool
 */
public class ExecutorEx2 {

    /**
     * 适用于单体任务量轻的场景，重量任务不可用
     * @param args /
     * @throws InterruptedException /
     */
    public static void main(String[] args) throws InterruptedException {

        ExecutorService pool = Executors.newCachedThreadPool();

        System.out.println(((ThreadPoolExecutor) pool).getActiveCount());

        pool.execute(()-> System.out.println("================"));
        System.out.println(((ThreadPoolExecutor) pool).getActiveCount());

        IntStream.rangeClosed(0,99).forEach(i->pool.execute(
                ()->{
                    try {
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "[" + i + "]");
                }));

        TimeUnit.SECONDS.sleep(1);

        System.out.println(((ThreadPoolExecutor) pool).getActiveCount());

        TimeUnit.SECONDS.sleep(12);

        System.out.println(((ThreadPoolExecutor) pool).getActiveCount());

    }

    private static void useSinglePool() {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
    }

    @Test
    public void test1() {
        Optional.of(Runtime.getRuntime().availableProcessors())
                .ifPresent(System.out::println);

        //方法的意义？
        Optional.of(null)
                .ifPresent(System.out::println);
    }

}
