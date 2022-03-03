package com.yunn.autumn.thread.threadenhance2.design.sync;

/**
 * AsynFuture
 *
 * @author: yunN
 * @createTime: 2021/01/15
 * @description:
 */
public class AsynFuture<T> implements Future<T> {

    private volatile boolean DONE = false;

    private T result;

    public void done(T result) {
        //FIXME:你知道this锁 锁的是什么吗 锁的是调用者本身？
        synchronized (this) {
            this.result = result;
            this.DONE = true;
            this.notifyAll();
        }
    }


    @Override
    public T get() throws InterruptedException {
        synchronized (this) {
            while (!DONE) {
                this.wait();
            }
        }
        return result;
    }
}
