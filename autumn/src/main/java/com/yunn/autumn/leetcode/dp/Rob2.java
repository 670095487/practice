package com.yunn.autumn.leetcode.dp;

import java.util.Arrays;

/**
 * @author yunN
 * @date 2022/10/07
 */
public class Rob2 {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        int[] dp = new int[n];
        if (n == 2) return Math.max(nums[0], nums[1]);
        // 偷第一个
        dp[0] = nums[0];
        dp[1] = nums[0];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }

        int x = dp[n - 2];// n长度的数组 dp[n-1]就是最后一个值，所以偷第一个，不偷最后一个，max = dp[n-2]

        // 不偷第一个
        Arrays.fill(dp, 0);// 初始化dp数组
        dp[0] = 0;
        dp[1] = nums[1];

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }

        int y = dp[n-1];



        return Math.max(x, y);
    }
}
