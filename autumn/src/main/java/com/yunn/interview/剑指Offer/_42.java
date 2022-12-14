package com.yunn.interview.剑指Offer;

import org.junit.Test;

/**
 * @author yunN
 * @date 2022/12/14.
 */
public class _42 {

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int num : dp) {
            max = Math.max(num, max);
        }
        return max;
    }

    @Test
    public void test() {
        int[] nums = {-1};
        maxSubArray(nums);
    }
}
