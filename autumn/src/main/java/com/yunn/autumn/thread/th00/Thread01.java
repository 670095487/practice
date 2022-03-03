package com.yunn.autumn.thread.th00;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Thread01
 *
 * @Author: Bff
 * @CreateTime: 2020-04-18
 * @Description:
 */
public class Thread01 {
    private final AtomicInteger firstJobDone = new AtomicInteger(0);
    private final AtomicInteger secondJobDone = new AtomicInteger(0);

    public void Thread01() {
    }

    public void setFirstJobDone(Runnable printFirst) {
        printFirst.run();
        firstJobDone.decrementAndGet();
    }

    public void setSecondJobDone(Runnable printFirst) {
        while (firstJobDone.get() != 1) {
        }
        printFirst.run();
        secondJobDone.decrementAndGet();
    }

}
