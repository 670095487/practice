package com.yunn.interview.剑指Offer;

import org.junit.Test;

/**
 * @author yunN
 * @date 2022/12/08.
 */
public class _53_1 {

    // 不是简单的二分
    public int search(int[] nums, int target) {
        int count = 0;
        int left = 0, right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid;
            } else if (nums[mid] == target){
                count++;
            }
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println(search(new int[]{5,7,7,8,8,10}, 8));
    }
}
