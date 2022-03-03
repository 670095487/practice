package com.yunn.autumn.thread.threadenhance3.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;
import java.util.stream.Collectors;

/**
 * StampedLockEx1
 *
 * @author yunN
 * @createTime 2021年02月02日 17:03
 * @description
 */
@SuppressWarnings("all")
public class StampedLockEx1 {

    private final static StampedLock LOCK = new StampedLock();

    private final static List<Long> DATA = new ArrayList<>();

    /**
     * 当多个读线程 一个写线程同时工作时，写线程有可能会处于长期拿不到锁的状态
     *
     * @param args /
     */
    public static void main(String[] args) {
        final ExecutorService pools = Executors.newFixedThreadPool(10);
        Runnable readTask = () -> {
            while (true) {
                read();
            }
        };

        Runnable writeTask = () -> {
            while (true) {
                write();
            }
        };

        // pools.submit(readTask);
        // pools.submit(readTask);
        // pools.submit(readTask);
        // pools.submit(readTask);
        // pools.submit(readTask);
        // pools.submit(readTask);
        // pools.submit(readTask);
        // pools.submit(readTask);
        // pools.submit(readTask);
        // pools.submit(readTask);
        pools.submit(readTask);
        pools.submit(readTask);
        pools.submit(writeTask);
    }

    private static void read() {
        long stamped = -1;
        try {
            stamped = LOCK.readLock();
            Optional.of(DATA.stream().map(String::valueOf)
                    .collect(Collectors.joining("#", "R-", "")));
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            LOCK.unlockRead(stamped);
        }
    }

    private static void write() {
        long stamped = -1;
        try {
            stamped = LOCK.writeLock();
            DATA.add(System.currentTimeMillis());
            // System.out.println("P" + DATA.size());
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            LOCK.unlockWrite(stamped);
        }
    }
}
