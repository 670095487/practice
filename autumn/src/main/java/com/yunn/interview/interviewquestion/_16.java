package com.yunn.interview.interviewquestion;

import org.junit.Test;

/**
 * @date 2022/12/31
 */
public class _16 {

    // 快速幂思想 x^12 = x^2 * x^4 * x^6
    public double myPow(double x, int n) {
        if (x == 0) return 1;
        double ans = 1;
        long f = n;
        if (f < 0) {
            f = -f;
            x = 1 / x;
        }
        while (f > 0) {
            if (f % 2 == 1) {
                ans = ans * x;
            }
            x = x * x;
            f = f / 2;
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(myPow(2.0, 10));
    }
}
