package com.yunn.autumn.thread.lock;

import java.util.Collection;

/**
 * Lock
 *
 * @description: 锁接口
 */
public interface MyLock {

    class TimeOutException extends Exception {

        private static final long serialVersionUID = 3841972005673207437L;

        public TimeOutException(String message) {
            super(message);
        }
    }

    /**
     * 加锁
     *
     * @throws InterruptedException /
     */
    void lock() throws InterruptedException;

    /**
     * 加锁-->锁有时效性
     *
     * @param mills /
     * @throws InterruptedException /
     * @throws TimeOutException     /
     */
    void lock(long mills) throws InterruptedException, TimeOutException;

    /**
     * 解锁
     */
    void unlock();

    /**
     * 获取当前所有blocked的线程
     *
     * @return /
     */
    Collection<Thread> getBlockThread();

    /**
     * 获取当前所有blocked的线程的总个数
     *
     * @return /
     */
    int getBlockedSize();

}
