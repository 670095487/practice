package com.yunn.interview.interviewquestion;

/**
 * @date 2022/12/18
 */
public class _21 {

    public int[] exchange(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int left = 0, right = n - 1;
        for (int num : nums) {
            if (num % 2 == 0) {
                ans[right] = num;
                right--;
            } else {
                ans[left] = num;
                left++;
            }
        }

        return ans;
    }
}
