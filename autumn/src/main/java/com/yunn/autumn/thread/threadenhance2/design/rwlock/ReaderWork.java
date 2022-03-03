package com.yunn.autumn.thread.threadenhance2.design.rwlock;

/**
 * ReaderWork
 *
 * @author: yunN
 * @createTime: 2021/01/14
 * @description:
 */
public class ReaderWork extends Thread {

    private final ShareData data;

    public ReaderWork(ShareData data) {
        this.data = data;
    }

    @Override
    public void run() {
        try {
            while (true) {
                char[] readBuf = data.read();
                System.out.println(Thread.currentThread().getName() + " reads " + String.valueOf(readBuf));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
