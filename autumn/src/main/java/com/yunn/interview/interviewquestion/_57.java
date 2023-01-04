package com.yunn.interview.interviewquestion;

/**
 * @date 2022/12/18
 */
public class _57 {

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left < right) {
            int s = nums[left] + nums[right];
            if (s < target) {
                left++;
            } else if (s > target) {
                right--;
            } else {
                return new int[]{nums[left], nums[right]};
            }
        }
        return new int[0];
    }
}
