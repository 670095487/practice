package com.yunn.autumn.thread.threadenhance2.design.sync;

/**
 * SyncInvoker
 *
 * @author: yunN
 * @createTime: 2021/01/15
 * @description: 异步调用--future设计模式演示
 */
public class client {

    public static void main(String[] args) throws InterruptedException {
        FutureService futureService = new FutureService();
        Future<String> future = futureService.submit(() -> {
            try {
                System.out.println("异步调用下游");
                //模拟业务逻辑，需要做的事情
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "FINISH";
        }, System.out::println);

        System.out.println("do other thing begin");
        Thread.sleep(1000L);
        // System.out.println(future.get());//会阻塞当前线程
        System.out.println("do other thing end");
    }

    @org.jetbrains.annotations.NotNull
    private static String getRs() throws InterruptedException {
        Thread.sleep(1000);
        return "FINISH";
    }
}
