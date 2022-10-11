package com.yunn.autumn.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author yunN
 * @date 2022/10/08
 */
public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        // 先排序
        // 返回第K-1个索引元素
        Arrays.sort(nums);

        return nums[nums.length-k];

    }

    @Test
    public void test() {
        int[] arr = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        findKthLargest(arr, 1);
    }
}
