package com.yunn.autumn.leetcode;

import java.util.Arrays;

/**
 * RemoveDuplicates
 *
 * @author yunN
 * @createTime 2021年03月09日 11:19
 * @description 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，
 * 返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {

        if (nums.length == 0) return 0;

        int i = 0;
        /*
         *不会生成一个新的数组，是直接在原有数组基础上移动指针所对应的元素
         * */
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {//如果下一个不等于上一个
                i++;//序列号+1
                nums[i] = nums[j];//指针后移
            }
        }
        System.out.println(Arrays.toString(nums));
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(removeDuplicates(nums));
    }
}
