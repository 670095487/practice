package com.yunn.autumn.sourcecode;

/**
 * MyTest
 *
 * @author: yunN
 * @createTime: 2020年10月16日 16:16
 * @description: 并发学习笔记
 */
@SuppressWarnings("all")
public class CourrencyStudyNotes<T> {

    /**
     * 无效锁
     *
     * @param args
     */
    public static void main(String[] args) {
        Object object = new Object();
        synchronized (object) {
            System.out.println("baby love");
        }
    }

    /**
     * 无锁-->偏向锁-->轻量级锁-->重量级锁
     * <p>
     * 偏向锁：
     * '偏向不获取、释放锁这一过程'，当一个线程首次获得这个对象的锁时，会将这个线程以及它的id记录下，等下一次这个线程再来尝试获取这个对象的锁时
     * 会首先比对这个线程的id和当前记录的id是否相等，如果相等则不再尝试获取锁，直接放行。/
     * <p>
     * 若第二次尝试获取该对象的线程已经不是第一次那个线程了，那么第二次的线程将会以CAS的方式尝试获取锁，若获取锁的动作成功，则该对象的锁仍旧是偏
     * 向锁；
     * 若获取失败，则该对象的锁会升级成为轻量级别的锁。
     * <p>
     * 轻量锁：
     * 也就是每次都需要进行获取锁、释放锁的操作
     * <p>
     * 重量级别的锁：
     * 在轻量锁的基础上，如果一个线程在经历过自旋以后，仍旧无法获取到锁，这个时候，对象锁就会升级成为重量级锁
     * <p>
     * 自旋锁：
     * 避免线程频繁进入阻塞而设计的，其原理为：让等待锁权限的线程在进入waitSet之前先自旋等待一会儿，如果在等待的时间里获取到了锁，那么就不用进入
     * 到waitSet集合中，也就避免了其进入到内核态，进入阻塞，减少了cpu调度的开销
     * 若自旋时间结束以后，等待的线程还没有获取到对象锁，那么对象锁就会升级至重量级锁，所有后续需要获取锁的线程在获取锁失败以后都会进入waitSet
     * 集合中。
     * <p>
     * 锁的升级过程是不可逆的。
     * <p>
     * synchronized关键字 作用在代码块上：是 moniterenter + moniterexit
     * 作用在方法上：    是ACC_SYNCHRONIZED
     * <p>
     * 竞争锁的线程会被放到entryList中，调用wait()方法进入等待状态的线程会进入waitSet集合中，在调用了notify()/notifyAll()【「唤醒不是随机
     * 的，是会根据不同的策略唤醒执定的线程」】后，被唤醒的线程
     * 会先进入entryList中，在竞争成功后才会获得锁。
     * <p>
     * <p>
     * 死锁：
     * 两个线程相互持有对方所需要的资源，导致两个线程都无法继续执行
     * <p>
     * 饿死：低优先级的线程始终拿不到运行所需的资源，导致进入无限等待
     */
    public void concurrency() {

    }

    /**
     * lock
     */

    public void lock() {
        // Lock lock = new ReentrantReadWriteLock.ReadLock();
    }
}
