package com.yunn.autumn.thread.lock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

/**
 * BooleanLock
 *
 * @Author: Bff
 * @CreateTime: 2021-01-04
 * @Description: 实现锁接口
 */
public class BooleanMyLock implements MyLock {

    /**
     * 定义锁值，true-->此时可以加锁
     * false-->此时不可加锁
     */
    private boolean initValue;

    /**
     * 将所有被阻塞的线程存放到此集合,用以显示观察到哪些线程被阻塞了以及被阻塞的线程总个数
     */
    private final Collection<Thread> blockedThreadCollection = new ArrayList<>();

    /**
     * 定义一个变量用来记录当前线程信息,用以确保加锁的线程和解锁的线程锁同一个
     */
    private Thread currentThread;

    /**
     * 这是一个加锁的方法
     * 理解：线程主动调用lock(),开始加锁。。。
     *
     * @throws InterruptedException
     */
    @Override
    public synchronized void lock() throws InterruptedException {
        //true--说明已经被其他线程加过锁了，此时进来的线程需要等待其他线程释放锁，才可以再次加锁
        while (initValue) {
            blockedThreadCollection.add(Thread.currentThread());
            this.wait();
        }
        //没有走上面的while说明了此时处于可以拿锁的状态,拿完锁后立即将锁值改为true
        blockedThreadCollection.remove(Thread.currentThread());
        initValue = true;
        //保存当前加锁的线程的信息，在解锁方法中用以保证解锁的线程和加锁的线程锁一个线程
        currentThread = Thread.currentThread();
    }

    /**
     * 指定等待时间的锁
     *
     * @param mills /
     * @throws InterruptedException /
     * @throws TimeOutException     /
     */
    @Override
    public synchronized void lock(long mills) throws InterruptedException, TimeOutException {
        //指定等待时间为负值，调用不限时lock()
        if (mills <= 0) lock();

        //指定等待时间
        long hasRemaining = mills;
        long endTime = System.currentTimeMillis() + mills;//超时时间点
        while (initValue) {
            //已超时
            if (hasRemaining <= 0) throw new TimeOutException("Wait Time out");
            //添加当前至阻塞线程集合
            blockedThreadCollection.add(Thread.currentThread());
            this.wait(mills);
            //计算本次循环后剩余等待时间
            hasRemaining = endTime - System.currentTimeMillis();
        }
        //获取锁成功,将锁标志至为true,后续过来的线程都会进入wait状态
        this.initValue = true;
        this.currentThread = Thread.currentThread();
    }

    /**
     * 线程主动调用unlock()方法用以解锁代码块，进入方法后需要立即将锁值赋为false,标记着锁已解除，
     * 并唤醒其他正在等待锁的线程去进行竞争。
     * 但是注意，锁的释放应该由加该锁的线程去释放，其他的线程不可以释放锁
     */
    @Override
    public synchronized void unlock() {
        if (Thread.currentThread() == currentThread) {
            initValue = false;
            Optional.of(Thread.currentThread().getName() + " 释放了锁")
                    .ifPresent(System.out::println);
            this.notifyAll();
        }
    }

    @Override
    public Collection<Thread> getBlockThread() {
        //若有其他线程修改了blockedThreadCollection，就会报错，杜绝脏写
        return Collections.unmodifiableCollection(blockedThreadCollection);
    }

    @Override
    public int getBlockedSize() {
        return blockedThreadCollection.size();
    }
}
