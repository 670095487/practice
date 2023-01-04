package com.yunn.interview.interviewquestion;

import org.junit.Test;

/**
 * @author yunN
 * @date 2022/12/14.
 */
public class _46 {
    public int translateNum(int num) {
        char[] nums = String.valueOf(num).toCharArray();
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int val = (nums[i - 2] - '0') * 10 + (nums[i - 1] - '0');
            if (val <= 25 && val >= 10) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[n];
    }

    @Test
    public void test() {
        translateNum(12258);
    }
}
