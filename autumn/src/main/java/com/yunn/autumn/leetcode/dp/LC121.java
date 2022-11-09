package com.yunn.autumn.leetcode.dp;

/**
 * @author yunN
 * @date 2022/11/02.
 */
public class LC121 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] profit = new int[n];
        for (int i = 0; i < n; i++) {
            int maxProfit = 0;
            int buyIn = prices[i];
            for (int j = i + 1; j < n; j++) {
                if (prices[j] - buyIn > 0) {
                    maxProfit = Math.max(maxProfit, prices[j] - buyIn);
                }
            }
            profit[i] = maxProfit;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, profit[i]);
        }
        return ans;
    }

    // 逻辑优化
    public int maxProfit2(int[] price) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < price.length; i++) {
            if (price[i] < minPrice) {
                minPrice = price[i];
            } else if (price[i] - minPrice > maxProfit) {
                maxProfit = price[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
