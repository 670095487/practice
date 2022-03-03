package com.yunn.autumn.sourcecode.concurrency;

/**
 * Obj
 *
 * @author: yunN
 * @createTime: 2020年10月21日 17:46
 * @description:
 */
public class Obj {
    private int count = 0;

    public synchronized void addCount() {
        while (count != 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count++;
        System.out.println(count);
        notify();
    }

    /**
     * t1进入
     * 条件满足
     * 执行--
     * <p>
     * t2进入  ？ t2如何在t1没有退出的时候进入？
     * 条件满足
     * 执行--
     * <p>
     * 当有2个--的线程被唤醒同时在wait状态【已经进入到--方法中了，所以当第二个被唤醒的--线程，就会导致count减至负数】
     * wait()方法会释放锁，也就是说当线程进入到--方法中，又wait()了以后，这个锁就会被释放了，就会存在有多个线程都进入
     * 到--方法中，但是他们并不是同时进入的。
     */
    public synchronized void subtractCount() {
        while (count == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        System.out.println(count);
        notify();//唤醒线程具有随机性， 可能唤醒的还是--的线程，导致死锁。且notify()只能随机唤醒处于wait()集合中的一个线程，
        //且线程被唤醒以后，还需要和其他线程取竞争锁，只有拿到锁的线程才能继续执行下去
    }
}
