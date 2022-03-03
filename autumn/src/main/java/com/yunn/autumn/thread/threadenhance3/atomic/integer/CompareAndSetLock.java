package com.yunn.autumn.thread.threadenhance3.atomic.integer;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CompareAndSetLock
 *
 * @author: yunN
 * @createTime: 2021/01/27 19:54:08
 * @description: 自定义比较锁
 */
public class CompareAndSetLock {

    private final AtomicInteger value = new AtomicInteger(0);

    private Thread lockThread;

    public void tryLock() throws GetLockException {
        boolean success = value.compareAndSet(0, 1);
        if (!success) throw new GetLockException("get the lock failed");
        else lockThread = Thread.currentThread();
    }

    public void unlock() {
        //如果已经是0了，那么不需要再解锁，直接返回即可。
        if (0 == value.get()) {
            return;
        }
        /*
            1.判断解锁的线程是否是加锁的线程
            2.是则将锁置为0
         */
        if (lockThread == Thread.currentThread())
            value.compareAndSet(1, 0);
    }

}
