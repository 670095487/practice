package com.yunn.interview.剑指Offer;

import org.junit.Test;

/**
 * @date 2022/12/13
 * dp会超时
 */
public class _10_1And2 {

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

    // 最优解
    public int numsWay(int n) {
        final int mod = 1000000007;
        int l1 = 1, l2 = 1, sum = 0;
        for (int i = 0; i <= n; i++) {
            sum = (l1 + l2) % mod;
            l1 = l2;
            l2 = sum;
        }
        return l1;
    }

    // 递归解法
    public int numWays(int n) {
        int[] dp = new int[n + 1];
        return dp(n, dp);
    }

    private int dp(int n, int[] dp) {
        if (n < 2) {
            return 1;
        }
        // 已有记录，返回即可
        if (dp[n] > 0) {
            return dp[n];
        }
        // dp 通项 ? 一次1阶 或 一次2阶
        return dp(n - 1, dp) % 1000000007 + dp(n - 2, dp) % 1000000007;
    }

    // 动态规划解法
    public int numWays_2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    @Test
    public void test() {
        System.out.println(fib(3));
    }
}
