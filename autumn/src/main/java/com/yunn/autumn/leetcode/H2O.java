package com.yunn.autumn.leetcode;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * H2O
 *
 * @author yunN
 * @createTime 2021年04月17日 21:27
 * @description 换句话说:
 * <p>
 * 如果一个氧线程到达屏障时没有氢线程到达，它必须等候直到两个氢线程到达。
 * 如果一个氢线程到达屏障时没有其它线程到达，它必须等候直到一个氧线程和另一个氢线程到达。
 * 书写满足这些限制条件的氢、氧线程同步代码。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/building-h2o
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class H2O {

    ReentrantLock lock = new ReentrantLock();
    //o、h元素满足条件的队列
    Condition oFull = lock.newCondition();//o队列用来输出h
    Condition hFull = lock.newCondition();//h队列用来输出o
    //-------------------------------------------------------------------------------------------------------------------

    /**
     * 目前h元素的数量
     */
    int hNum = 0;

    Semaphore hsm = new Semaphore(2);
    Semaphore osm = new Semaphore(0);

    /**
     * H必须等到另外2个HO 才能被输出
     * O必须等到另外2个HH 才能被输出
     */
    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        //尝试获取许可
        hsm.acquire();
        //获取到许可以后执行 print h
        releaseHydrogen.run();
        //打印 h+1
        hNum++;
        //这句代D码很重要，没有就会陷入假死
        /*
            如果hnum == 2 ,此时需要释放一个许可给print o的线程，让print o的线程从阻塞态中被释放出来
         */
        if (hNum == 2) {
            osm.release(1);
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        osm.acquire();
        releaseOxygen.run();
        hsm.release(2);
        hNum = 0;
    }


}
