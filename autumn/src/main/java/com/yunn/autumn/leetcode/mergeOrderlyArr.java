package com.yunn.autumn.leetcode;

import java.util.Arrays;

/**
 * @author yunN
 * @date 2022/03/03.
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class mergeOrderlyArr {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i != n; i++) {
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}
