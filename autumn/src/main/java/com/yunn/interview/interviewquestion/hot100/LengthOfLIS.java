package com.yunn.interview.interviewquestion.hot100;

import org.junit.Test;

import java.util.Arrays;

/**
 * @date 2023/01/14
 */
public class LengthOfLIS {

    /**
     * dp:
     *  dp[i]代表的nums数组以i结尾的元素在nums中严格升序的最长子序列的长度
     */
    public int lengthOfLIS(int[] nums) {
        int max = 0;
        int n = nums.length;
        int[] dp = new int[n];
        // 表示如果每一位元素都是一个单独的升序序列
        Arrays.fill(dp,1);
        for (int i = 0; i < n; i++) {
            // j属于[0,i), dp的意义就是要计算第i位的元素，能在[0,i-1]范围内，成为几个元素的升序序列位
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    @Test
    public void test() {
        int[] arr = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        lengthOfLIS(arr);
    }
}
