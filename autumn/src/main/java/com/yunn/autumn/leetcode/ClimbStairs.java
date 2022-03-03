package com.yunn.autumn.leetcode;

import org.junit.Test;

/**
 * @author yunN
 * @date 2021/12/30
 */
public class ClimbStairs {


    /**
     * will cause stack overflow
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairs1(int n) {
        // a: f(x-1) b: f(x-2) c: f(x)
        int a, b = 0, c = 1;
        for (int i = 0; i < n; i++) {
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }

    @Test
    public void test() {
        System.out.println(climbStairs1(5));
    }
}
