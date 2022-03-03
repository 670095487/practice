package com.yunn.autumn.thread.threadenhance2.design.rwlock;

/**
 * Client
 *
 * @author: yunN
 * @createTime: 2021/01/14
 * @description:
 */
public class Client {

    public static void main(String[] args) {
        final ShareData shareData = new ShareData(10);
        new ReaderWork(shareData).start();
        new ReaderWork(shareData).start();
        new WriterWork(shareData, "qwewewqeqewqeq").start();
        new WriterWork(shareData, "QWEWEWQEQEWQEQ").start();
    }
}
