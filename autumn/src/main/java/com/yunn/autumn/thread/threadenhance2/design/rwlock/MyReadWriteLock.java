package com.yunn.autumn.thread.threadenhance2.design.rwlock;

/**
 * ReadWriteLock
 *
 * @author: yunN
 * @createTime: 2021/01/13
 * @description: 自定义读写分离锁
 */
public class MyReadWriteLock {
    /**
     * 读线程的数量
     */
    private int readingReaders = 0;

    /**
     * 等待的读线程数量
     */
    private int waitingReaders = 0;

    /**
     * 写线程的数量
     */
    private int writingWriters = 0;

    /**
     * 等待的写线程的数量
     */
    private int waitingWriters = 0;

    /**
     * 是否要调高写线程的优先级
     * 默认需要提高
     */
    private boolean preferWriter = true;

    /**
     * 默认构造出来的读写锁是需要提高写线程的优先级的
     */
    public MyReadWriteLock() {
        this(true);
    }

    /**
     * 交给调用者选择 是否需要提高写线程的优先级
     *
     * @param preferWriter /
     */
    public MyReadWriteLock(boolean preferWriter) {
        this.preferWriter = preferWriter;
    }

    /**
     * 读 +锁
     *
     * @throws InterruptedException .
     */
    public synchronized void readLock() throws InterruptedException {
        //等待读的线程+1
        this.waitingReaders++;
        /*
         * 1.如果当前写线程大于0，那么本次执行的读线程就等待，直到写线程结束
         * 2.如果 设置了需要提高写线程的优先级 且 正在等待的写线程大于0 ，那么本次执行的读线程就主动让出锁，让写线程先执行
         * */
        try {
            while (writingWriters > 0 || (preferWriter && waitingWriters > 0)) {
                this.wait();
            }
            this.readingReaders++;
        } finally {
            //每次都保证读线程-1，读失败也是？
            this.waitingReaders--;
        }
    }

    /**
     * 读 -锁
     *
     * @throws InterruptedException .
     */
    public synchronized void readUnLock() throws InterruptedException {
        this.readingReaders--;
        this.notifyAll();
    }

    /**
     * 写 +锁
     *
     * @throws InterruptedException .
     */
    public synchronized void writeLock() throws InterruptedException {
        //写锁 +1
        this.waitingWriters++;
        /*
         * 1.有读线程 不能写
         * 2.有写线程 不能写
         *
         * */
        try {
            while (writingWriters > 0 || readingReaders > 0) {
                this.wait();
            }
        } finally {
            //释放一个正在等的写线程
            this.waitingWriters--;
        }
    }

    /**
     * 写 -锁
     *
     * @throws InterruptedException .
     */
    public synchronized void writeUnLock() throws InterruptedException {
        this.writingWriters--;
        this.notifyAll();
    }
}
