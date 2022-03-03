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
 * StampedLockEx2
 *
 * @author yunN
 * @createTime 2021年02月02日 19:47
 * @description
 */
@SuppressWarnings("all")
public class StampedLockEx2 {

    private final static StampedLock LOCK = new StampedLock();

    private final static List<Long> DATA = new ArrayList<>();

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

        pools.submit(readTask);
        pools.submit(readTask);
        pools.submit(readTask);
        //写线程一直占着锁 ？
        pools.submit(writeTask);
    }

    private static void read() {
        long stamped = LOCK.tryOptimisticRead();
        if (LOCK.validate(stamped)) {
            try {
                stamped = LOCK.readLock();
                Optional.of(DATA.stream()
                        .map(String::valueOf).collect(Collectors
                                .joining("#", "R-", ""))).ifPresent(System.out::println);
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                //
            } finally {
                LOCK.unlockRead(stamped);
            }
        }
    }

    private static void write() {
        long stamped = -1;
        try {
            stamped = LOCK.writeLock();
            DATA.add(System.currentTimeMillis());
            System.out.println("P" + DATA.size());
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            LOCK.unlockWrite(stamped);
        }
    }
}
