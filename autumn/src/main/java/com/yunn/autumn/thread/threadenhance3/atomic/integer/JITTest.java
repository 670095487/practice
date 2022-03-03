package com.yunn.autumn.thread.threadenhance3.atomic.integer;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * JITTest
 *
 * @author: yunN
 * @createTime: 2021/01/27 16:15:34
 * @description:
 */
public class JITTest {

    private static volatile boolean init = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread() {
            @Override
            public void run() {
                /*
                   JIT 优化此代码为 while(true){}
                   ,当循环体中有代码时，JIT就不会优化其代码顺序了
                 */
                while (!init) {
                    System.out.println(";;;;");
                }


            }
        }.start();

        Thread.sleep(1000);

        new Thread() {
            @Override
            public void run() {
                init = true;
                System.out.println("set init to true");
            }
        }.start();
    }

    @Test
    public void compareAndSetTest() {
        AtomicInteger i = new AtomicInteger(10);
        boolean b = i.compareAndSet(10, 222);
        System.out.println(i.get());
        System.out.println(b);
    }
}
