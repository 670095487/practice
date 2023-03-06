package com.yunn.interview.interviewquestion.d;

import org.junit.Test;

/**
 * @author yunN
 * @date 2023/02/13.
 */
public class MinSubArray {

    /*
        滑动窗口
            1. left = 0, right = 0;

    */
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int n = nums.length;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                // 缩小左边界，找到最少元素和能满足条件的子集，不满足条件以后，右边界向后平移
                sum -= nums[left++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    @Test
    public void test() {
        int[] arr = new int[]{2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, arr));
    }
}
