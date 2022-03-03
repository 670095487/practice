package com.yunn.autumn.leetcode;

/**
 * SearchInsert
 *
 * @author yunN
 * @createTime 2021年03月10日 16:18
 * @description 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 */
public class SearchInsert {

    public int searchInsert(int[] nums, int target) {

        int returnIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) return i;
        }
        //筛选出数组中最大的元素和最小的元素
        if (target < nums[0]) return 0;
        if (target > nums[nums.length - 1]) return nums.length;

        //比较大小，返回下标。
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target) return i == 1 ? 1 : i - 1;
        }
        return returnIndex;
    }
}
