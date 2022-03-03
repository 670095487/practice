package com.yunn.autumn.thread.threadenhance3.atomic.integer;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicIntegerTest
 *
 * @author: yunN
 * @createTime: 2021/01/27 15:42:29
 * @description:
 */
public class AtomicIntegerTest {

    /**
     * 1.内存可见性
     * 2.内存屏障
     * 3.不保证原子性
     */
    private static volatile int value = 0;

    // volatile 复习
//    1.get value
//    2.modify
//    3.assgin
//    4.flush to main memory

    //线程安全的set
    private static final Set<Integer> set = Collections.synchronizedSet(new HashSet<>());


    public static void main(String[] args) throws InterruptedException {
        AtomicInteger value = new AtomicInteger(0);
        Thread t1 = new Thread() {
            @Override
            public void run() {
                int x = 0;
                while (x < 500) {
                    int v = value.getAndIncrement();
                    set.add(v);
                    x++;
                }
            }
        };
        t1.start();
        t1.join();//t1 join 则代表main线程要等t1执行完毕才能结束，这样才能统计到set.size的最终长度

        System.out.println(set.size());
    }


}
