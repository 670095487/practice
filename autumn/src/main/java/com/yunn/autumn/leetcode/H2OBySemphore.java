package com.yunn.autumn.leetcode;

import java.util.concurrent.Semaphore;

/**
 * Created by yunN on 2021/04/18.
 */
@SuppressWarnings("all")
public class H2OBySemphore {

    volatile int hNum = 0;

    private final Semaphore hsem = new Semaphore(2);

    private final Semaphore osem = new Semaphore(0);

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        while (hNum == 2){
            osem.release(1);
        }
        hsem.acquire();
        releaseHydrogen.run();
        hNum++;
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        osem.acquire();
        releaseOxygen.run();
        hsem.release(2);
        hNum = 0;
    }
}
