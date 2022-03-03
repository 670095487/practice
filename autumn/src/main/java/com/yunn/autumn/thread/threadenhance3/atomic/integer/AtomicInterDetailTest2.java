package com.yunn.autumn.thread.threadenhance3.atomic.integer;

import lombok.SneakyThrows;

/**
 * AtomicInterDetailTest2
 *
 * @author: yunN
 * @createTime: 2021/01/27 19:27:59
 * @description:
 */
public class AtomicInterDetailTest2 {

    private final static CompareAndSetLock tryLock = new CompareAndSetLock();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(){
                @Override
                public void run() {
                    try {
                        doSomething2();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }

    private static void doSomething() throws InterruptedException {
        synchronized (AtomicInterDetailTest2.class) {
            System.out.println(Thread.currentThread().getName() + " get the lock");
            Thread.sleep(100000);
        }
    }

    /**
     * 若获取锁成功，则去做事情，否则直接返回。
     * @throws InterruptedException
     */
    @SneakyThrows
    private static void doSomething2() throws InterruptedException {
        try {
            tryLock.tryLock();
            System.out.println(Thread.currentThread().getName() + " get the lock");
            Thread.sleep(100000);
        }finally {
            tryLock.unlock();
        }
    }
}
