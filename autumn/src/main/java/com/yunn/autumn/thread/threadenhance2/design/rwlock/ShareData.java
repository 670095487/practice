package com.yunn.autumn.thread.threadenhance2.design.rwlock;

import java.util.Arrays;

/**
 * ShareData
 *
 * @author: yunN
 * @createTime: 2021/01/13
 * @description: 模拟共享数据
 */
public class ShareData {

    private final char[] buffer;

    private final MyReadWriteLock lock = new MyReadWriteLock();

    public ShareData(int size) {
        this.buffer = new char[size];
        Arrays.fill(buffer, '*');
    }

    public char[] read() throws InterruptedException {
        try {
            lock.readLock();
            return doRead();
        } finally {
            lock.readUnLock();
        }
    }


    public void write(char c) throws InterruptedException {
        try {
            lock.writeLock();
            System.out.println("write thread get lock");
            this.doWrite(c);
        } finally {
            lock.writeUnLock();
        }
    }

    public void doWrite(char c) {
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = c;
            slowly(10);
        }
    }

    private char[] doRead() {
        char[] newBuf = new char[buffer.length];
        System.arraycopy(buffer, 0, newBuf, 0, buffer.length);
        slowly(50);
        return newBuf;
    }

    private void slowly(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            //
        }
    }
}
