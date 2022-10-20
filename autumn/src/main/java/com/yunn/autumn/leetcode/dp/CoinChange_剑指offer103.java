package com.yunn.autumn.leetcode.dp;

import org.junit.Test;

/**
 * @author yunN
 * @date 2022/10/19.
 */
@SuppressWarnings("all")
public class CoinChange_剑指offer103 {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int n = coins.length;
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE - 1;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 /*&& dp[i - coins[j]] != Integer.MAX_VALUE*/) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                    System.out.println(dp[i]);
                }

            }
        }
        if (dp[amount] == Integer.MAX_VALUE) return -1;
        return dp[amount];
    }

    // 例题版本
    // 假设有2，5，7三枚硬币，数量无限，求出组成amount=27的最少硬币数目
    int dpRes = Integer.MAX_VALUE;

    public int coinExample() {
        int[] dp = new int[28];
        dp[0] = 0;// 金额0--0枚硬币就可以组成
        dp[1] = Integer.MAX_VALUE;// 金额1--没有可以实现的组合
        for (int i = 2; i <= 27; i++) {
        }
        return dp[27];
    }

    int res = Integer.MAX_VALUE;

    public int coinExampleUseRecursive(int amount) {
        if (amount == 0) return 0;
        if (amount == 1) return Integer.MAX_VALUE;
        if (amount >= 2) {
            res = Math.min(res, coinExampleUseRecursive(amount - 2) + 1);
        }
        if (amount >= 5) {
            res = Math.min(res, coinExampleUseRecursive(amount - 5) + 1);
        }
        if (amount >= 7) {
            res = Math.min(res, coinExampleUseRecursive(amount - 7) + 1);
        }
        return res;
    }


    @Test
    public void test() {
        // System.out.println(coinExampleUseRecursive(27));
        // System.out.println(coinExample());
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
    }

}
