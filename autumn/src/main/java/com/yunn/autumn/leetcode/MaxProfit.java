package com.yunn.autumn.leetcode;

/**
 * @author yunN
 * @date 2022/03/18
 */
public class MaxProfit {


    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans += Math.max(prices[i] - prices[i - 1], ans);
        }
        return ans;
    }

    public int maxProfit2(int[] prices) {
        return 0;
    }
}
