package com.yunn.interview.interviewquestion.hot100;

/**
 * @date 2023/01/17
 */
public class MaxProfit {


    /**
     * dp:
     * i代表第i天的最大收益,0代表不持有股票，1代表持有股票，2代表不持股但是是因为当天卖出去了
     * dp[i][0]:代表第i天不持有股票，不持有股票，有2种情况
     *    1. 第i-1天不持有股票，dp[i][0] = dp[i-1][0]
     *    2. 第i-1天持有股票，但是卖出了，dp[i][0] = dp[i-1][2]
     *    所以，dp[i][0] = MAX(dp[i-1][0], dp[i-1][2])
     * dp[i][1]:代表第i天持有股票，
     *    1. 股票是从第i-1天带过来的，dp[i][1] = dp[i-1][1]
     *    2. 股票是第i天买的，如果是第i天买的，那么第i-1天就绝不可能卖股票，所以第i-1天就只可能是0/1
     *    dp[i][1] = dp[i-1][0] - p[i],表示在昨天的收益上减去今天买入花费的金额
     *    所以,dp[i][1] = MAX(dp[i-1][1],dp[i-1][0] - p[i])
     * dp[i][2]:代表第i天持有股票且当天卖出
     *    1. 股票是从i-1天带过来的：dp[i][2] = dp[i-1][1] + p[i]
     *    2. 股票是第i天买入并卖出的（收益为0，不用考虑）
     *    所以，dp[i][2] = dp[i-1][1] + p[i]
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // 小于1,当天买入卖出，无收益
        if (n <= 1) {
            return 0;
        }
        int[][] dp = new int[n][3];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = dp[i - 1][1] + prices[i];
        }
        return Math.max(dp[n - 1][0], dp[n - 1][2]);
    }
}
