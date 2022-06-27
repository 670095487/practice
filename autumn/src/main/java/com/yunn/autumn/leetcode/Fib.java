package com.yunn.autumn.leetcode;

/**
 * @author yunN
 * @date 2022/06/27
 * 动态规划
 */
public class Fib {

    int[] memo;

    public int fib(int n) {
        this.memo = new int[n + 1];
        return dp(n, memo);
    }

    int dp(int x, int[] memo) {
        if (memo[x] != 0) {
            return memo[x];
        }
        if (x == 0) {
            return 0;
        }

        if (x == 1) {
            return 1;
        }
        memo[x] = dp(x - 1, memo) + dp(x - 2, memo);
        return memo[x];
    }

}
