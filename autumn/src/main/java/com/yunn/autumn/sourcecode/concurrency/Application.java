package com.yunn.autumn.sourcecode.concurrency;

/**
 * Application
 *
 * @author: yunN
 * @createTime: 2020年10月21日 17:48
 * @description:
 */
public class Application {
    public static void main(String[] args) {
        Obj obj = new Obj();
        AddThread addThread = new AddThread(obj);
        AddThread addThread2 = new AddThread(obj);
        SubtractThread subtractThread = new SubtractThread(obj);
        SubtractThread subtractThread2 = new SubtractThread(obj);
        addThread.start();
        addThread2.start();
        subtractThread.start();
        subtractThread2.start();
    }
}
