package com.yunn.autumn.effectiveJava;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Recursive
 *
 * @Author: yunN
 * @CreateTime: 2020/12/23
 * @Description:
 */
public class Recursive {


    // private final static AtomicInteger counter = new AtomicInteger(0);


    public void test1(AtomicInteger counter) {
        counter.getAndIncrement();
        System.out.println(Thread.currentThread().getName() + "线程第" + counter.get() + "次执行 test1()");
        if (counter.get() < 3) {
            test1(counter);
        }
    }

    @Test
    public void testTest1() {
        ExecutorService executorService1 = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {

            executorService1.execute(() -> test1(new AtomicInteger(0)));

        }
        // test1(0);
    }

    public void test2(int counter) {
        counter++;
        System.out.println(Thread.currentThread().getName() + "线程第" + counter + "次执行 test1()");
        if (counter < 3) {
            test2(counter);
        }
    }

    @Test
    public void testTest2() {
        ExecutorService executorService1 = Executors.newFixedThreadPool(30);
        for (int i = 0; i < 100; i++) {

            executorService1.execute(() -> test2(0));

        }
        // test1(0);
    }
}
