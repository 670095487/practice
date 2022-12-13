package com.yunn.autumn.leetcode.dp;

/**
 * @date 2022/11/02.
 */
public class LC121 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        // 收益
        int[] profit = new int[n];
        for (int i = 0; i < n; i++) {
            int maxProfit = 0;
            // cur buy in
            int buyIn = prices[i];
            // 往后+1，求max profit
            for (int j = i + 1; j < n; j++) {
                if (prices[j] - buyIn > 0) {
                    maxProfit = Math.max(maxProfit, prices[j] - buyIn);
                }
            }
            // 当前股票最大利润
            profit[i] = maxProfit;
        }
        int ans = 0;
        // max profit
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
