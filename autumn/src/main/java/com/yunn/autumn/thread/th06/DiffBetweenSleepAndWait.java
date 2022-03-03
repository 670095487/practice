package com.yunn.autumn.thread.th06;

/**
 * DiffBetweenSleepAndWait
 *
 * @Author: Bff
 * @CreateTime: 2020-05-06
 * @Description: 演示sleep()和wait()方法的不同点
 */
public class DiffBetweenSleepAndWait {
     /*
     * Wait()和sleep()的区别：
        1.sleep()是thread的方法，wait()是object的方法
        2.sleep()不会主动释放锁，但是wait()可以主动释放锁，并且将锁添加到对象队列
        * synchronized
        3. 使用sleep()不需要定义一个synchronized()方法，但是wait()需要
        4. 使用sleep()方法可以不被唤醒， 但是wait()需要被唤醒
     *
     * */
}
