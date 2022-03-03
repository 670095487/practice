package com.yunn.autumn.thread.threadenhance3.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * SemaphoreEx1
 *
 * @author: yunN
 * @createTime: 2021/02/01 18:52:56
 * @description:
 */
public class SemaphoreEx1 {

    public static void main(String[] args) {

        final SemaphoreLock lock = new SemaphoreLock();

        new Thread(()->{
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " get the lock!");
                TimeUnit.SECONDS.sleep(10);
            } catch (Exception e) {
            //
            }finally {
                lock.unlock();
            }
            System.out.println(Thread.currentThread().getName() + " relase the lock!");
        }).start();


        new Thread(()->{
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " get the lock!");
                TimeUnit.SECONDS.sleep(10);
            } catch (Exception e) {
                //
            }finally {
                lock.unlock();
            }
            System.out.println(Thread.currentThread().getName() + " relase the lock!");
        }).start();
    }

    static class SemaphoreLock{

        private final Semaphore semaphore = new Semaphore(1);

        public void lock() throws InterruptedException{
            semaphore.acquire();
        }

        public void unlock() {
            semaphore.release();
        }
    }

}
