package com.yunn.autumn.thread.threadenhance3.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * AIFUTest
 *
 * @author: yunN
 * @createTime: 2021/01/29 14:51:27
 * @description:
 */
public class AIFUTest {

    private volatile int i;

    /*
    * 如果将待操作的值直接定义为atomic类型的，也可以实现，但是会比较耗费内存。
    * 而使用AtomicIntegerFieldUpdater的话，只需要将需要改变的字段修饰为 volitle即可
    * */

    /*
    * 使用cas来代替某些需要加锁更新值的场景。
    * */
    private AtomicIntegerFieldUpdater<AIFUTest> updater =
            AtomicIntegerFieldUpdater.newUpdater(AIFUTest.class, "i");

    public void update(int newValue) {
        updater.compareAndSet(this, i, newValue);
    }

    public int get() {
        return i;
    }

    public static void main(String[] args) {
        AIFUTest test = new AIFUTest();
        test.update(10);
        System.out.println(test.get());
    }

}
