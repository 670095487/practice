package com.yunn.interview.剑指Offer;

import org.junit.Test;

/**
 * @date 2022/12/13
 */
public class _10_1 {

    // f0=0 f1=1 求fn
    public int fib(int n) {
        final int mod = 1000000007;
        if (n < 2) return n;
        int l1 = 0, l2 = 0, l3 = 1;
        for (int i = 2; i <= n; i++) {
            l1 = l2;
            l2 = l3;
            l3 = (l1 + l2) % mod;
        }
        return l3;
    }

    @Test
    public void test() {
        System.out.println(fib(3));
    }
}
