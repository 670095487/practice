package com.yunn.interview.thread;

/**
 * RunWithStart
 *
 * @author: yunN
 * @createTime: 2021/02/08 11:36:11
 * @description:
 */
public class RunWithStart {


    public static void main(String[] args) {
        Runnable r = ()->{
            System.out.println("run");
            System.out.println(Thread.currentThread().getName());
        };

        r.run();
        System.out.println("============================");
        new Thread(r).start();
    }
}
