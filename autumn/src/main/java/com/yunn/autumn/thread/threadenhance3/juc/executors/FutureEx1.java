package com.yunn.autumn.thread.threadenhance3.juc.executors;

import java.util.concurrent.*;

/**
 * FutureEx1
 *
 * @author: yunN
 * @createTime: 2021/02/06 14:39:33
 * @description: 演示
 */
@SuppressWarnings("all")
public class FutureEx1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        // testGet();
        // testGetWithTimeOut();
        testCancel();
    }


    private static void testGet() throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<Integer> future = executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10;
        });

        System.out.println("===now print===");

        Thread callerThread = Thread.currentThread();

        new Thread(()->{
            try {
                TimeUnit.MILLISECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            callerThread.interrupt();
        }).start();

        Integer result = future.get();

        System.out.println("============" + result +" =================");
    }

    private static void testGetWithTimeOut() throws InterruptedException, ExecutionException, TimeoutException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<Integer> future = executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
                System.out.println("=============");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10;
        });
        //对于调用者来说，5s就超时，但是对于线程本身来说，会将此任务执行完毕。
        // future.get(5, TimeUnit.SECONDS);
        TimeUnit.SECONDS.sleep(11);
        //1.程序正常结束、2.出现异常、3.被取消
        System.out.println(future.isDone());
    }

    private static void testCancel() {

        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<Integer> future = executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
                System.out.println("=============");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10;
        });

        System.out.println(future.cancel(true));
        //1.程序正常结束、2.出现异常、3.被取消
        System.out.println(future.isDone());
    }

    private static void futureDefect2() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

    }
}
