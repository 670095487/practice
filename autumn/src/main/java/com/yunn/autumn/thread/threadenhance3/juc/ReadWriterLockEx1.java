package com.yunn.autumn.thread.threadenhance3.juc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReadWriterLockEx1
 *
 * @author yunN
 * @createTime 2021年02月02日 11:15
 * @description 读写分离锁。
 */
public class ReadWriterLockEx1 {

    private final static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private final static Lock readLock = readWriteLock.readLock();

    private final static Lock writeLock = readWriteLock.writeLock();

    private final static List<Long> data = new ArrayList<>();

    /*
        junit不支持多线程测试。
     */
    @Test
    public void testLock() {
        Thread t1 = new Thread(() -> new ReadWriterLockEx1().read());
        Thread t2 = new Thread(() -> new ReadWriterLockEx1().write());

        t1.start();
        t2.start();
        System.out.println(Thread.currentThread().getName());
    }

    /*
    w-写，r-读 N-不允许 Y-允许
    w w N
    w r N
    r w N
    r r Y
    */
    public static void main(String[] args) {
        new Thread(new ReadWriterLockEx1()::write).start();
        new Thread(new ReadWriterLockEx1()::write).start();
        new Thread(new ReadWriterLockEx1()::read).start();
        // new Thread(new ReadWriterLockEx1()::read).start();

    }

    public void write() {
        try {
            writeLock.lock();
            data.add(System.currentTimeMillis());
            System.out.println(Thread.currentThread().getName()+" is write thread!");
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    public void read() {
        try {
            readLock.lock();
            data.forEach(System.out::println);
            System.out.println(Thread.currentThread().getName() + " is read thread");
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }
}
