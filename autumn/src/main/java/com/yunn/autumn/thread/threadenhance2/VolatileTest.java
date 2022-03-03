package com.yunn.autumn.thread.threadenhance2;

/**
 * VolatileTest
 *
 * @author: yunN
 * @createTime: 2021/01/11
 * @description:
 */
@SuppressWarnings("all")
public class VolatileTest {

    /**
     * volatile: 会强制令cpu每次都从主内存中取此变量的值 即内存可见
     * 若不加此关键字，cpu会将此值缓存值cpu cache中，多线程下，副本独立，值互相不可见，产生不安全问题
     * Tips:若一个线程对这个变量仅有读操作，那么jvm会认为它无需主存中最新的值，一旦将此值读到cache中，就不会再去主存中取了
     * 但是如果一个线程对这个变量不仅有读操作还有写操作，那么jvm还是会随机选择n次去主存中取值的。
     * <p>
     * 缓存不一致问题
     */
    private static volatile int INIT_VALUE = 0;

    private final static int MAX_LIMIT = 5;

    public static void main(String[] args) {

        //仅有读操作
        new Thread(() -> {
            int localValue = INIT_VALUE;
            while (localValue < MAX_LIMIT) {
                if (localValue != INIT_VALUE) {
                    System.out.printf("值即将被赋值为 [%d] \n", INIT_VALUE);
                    localValue = INIT_VALUE;
                }
            }
        }, "READER").start();

        //有修改操作
        new Thread(() -> {
            int localValue = INIT_VALUE;
            while (INIT_VALUE < MAX_LIMIT) {
                System.out.printf("值即将被更新成 [%d] \n", ++localValue);
                INIT_VALUE = localValue;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "UPDATER").start();
    }
}
/*
 * happens-before relationship
 * 3.1 代码的执行顺序，编写在前面的发生在编写后面的 【按顺序去执行】
 * 3.2 unlock必须发生在lock之后
 * 3.3 volatile修饰的变量，对于一个变量的写操作先于对该变量的读操作 【被volatile修饰的变量先写后读】
 * 3.4 传递规则，操作A先于B ，B先于C，那么A肯定先于C 【按序执行？】
 * 3.5 线程启动规则，start方法肯定先于线程run 【线程需要先启动才能调用run()】
 * 3.6 线程中断规则，interrupt这个动作，必须发生在捕获该动作之前 【只有这样才能保证interrupt能够被catch到】
 * 3.7 对象销毁规则，初始化必须发生在 finalize 之前 --TODO finalize?是什么？是垃圾回收机制最后会被GC调用
 * 3.8 线程终结规则，所有的操作都发生在线程死亡之前 【这是句废话？】
 *
 *  volatile关键字
 *  1.保证重排序的时候不会把后面的指令放到被volatile修饰的关键字的前面，也不会把前面的语句放到后面【理解为 严格按照代码的书写顺序执行代码】
 *  2.强制对缓存的修改操作会立刻写入主存，【会通知其他cpu此变量的缓存已失效，踢出各自缓存块？】
 *  3.如果是写操作，会导致其他cpu中的缓存失效。【第二条修改不会吗？】
 *
 * 并发编程的三大特性：
 *  原子性、可见性、有序性
 *
 * */