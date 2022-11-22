package com.yunn.autumn.leetcode;

import org.junit.Test;

/**
 * @author yunN
 * @date 2022/10/23
 */
public class LC724 {

    public int pivotIndex(int[] nums) {
        // 找到数组中满足左右两边和相等的index
        // 思路：暴力法，逐一计算数组中每一个元素的左右和是多少
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int leftSum = 0, rightSum = 0;
            if (i == 0) {
                for (int j = i + 1; j < n; j++) {
                    rightSum += nums[j];
                }
                if (rightSum != 0) {
                    continue;
                }

            }
            if(i == n - 1) {
                for (int j = i - 1; j >= 0; j--) {
                    leftSum += nums[j];
                }
                if (leftSum != 0) {
                    continue;
                }
            }

            for (int j = i + 1; j < n; j++) {
                rightSum += nums[j];
            }
            for (int j = i - 1; j >= 0; j--) {
                leftSum += nums[j];
            }

            System.out.println("i = " + i + ", lsum = " + leftSum + ", rsum = " + rightSum);
            if (rightSum == leftSum) return i;

        }
        return -1;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1,7,3,6,5,6};
        System.out.println(pivotIndex(nums));
    }
}
