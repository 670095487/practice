package com.yunn.autumn.leetcode;

import java.util.concurrent.CountDownLatch;
import java.util.function.IntConsumer;

/**
 * ZeroEvenOdd
 *
 * @author: yunN
 * @createTime: 2021/01/19 16:56:43
 * @description: 打印零与奇偶数
 */
public class ZeroEvenOdd {

    private final int n;

    private CountDownLatch latch_zero = new CountDownLatch(0);
    private CountDownLatch latch_odd = new CountDownLatch(1);
    private CountDownLatch latch_even = new CountDownLatch(1);


    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            latch_zero.await();
            printNumber.accept(0);
            //重置输出0锁，防止重复输出0
            latch_zero = new CountDownLatch(1);
            //如果i是偶数，说明此时需要打印出偶数？
            if (i % 2 == 0) {
                latch_even.countDown();
            } else {
                latch_odd.countDown();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i < n; i += 2) {
            latch_even.await();
            printNumber.accept(i);
            latch_even = new CountDownLatch(1);
            //无论0后面接的是奇数还是偶数，都需要将0对应的count-down数置为0
            latch_zero.countDown();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i < n; i++) {
            latch_odd.await();
            printNumber.accept(i);
            //重置奇数锁
            latch_odd = new CountDownLatch(1);
            latch_zero.countDown();
        }
    }
}
