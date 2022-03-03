package com.yunn.autumn.thread.异常堆栈;

/**
 * ThreadException
 *
 * @author: yunN
 * @createTime: 2021/01/05
 * @description: 如何捕获线程RuntimeException
 */
public class ThreadException {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(5_000L);
                int a = 1 / 0;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //使用此api 实现函数式接口主动捕获runtimeException
        t.setUncaughtExceptionHandler((t1, e) -> {
            System.out.println("捕获异常 = " + e);
            System.out.println("异常线程 = " + t1.getName());
        });
        t.start();
    }
}
