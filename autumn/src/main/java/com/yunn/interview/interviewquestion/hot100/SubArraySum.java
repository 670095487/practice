package com.yunn.interview.interviewquestion.hot100;

/**
 * @author yunN
 * @date 2023/02/01.
 */
public class SubArraySum {

    /*
      连续子数组和为k的子数组一共多少个
        滑动窗口：
     */
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int end = i; end >= 0; end--) {
                sum += nums[end];
                if (sum == k) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
