package com.yunn.autumn.leetcode;

import org.junit.Test;

/**
 * @author yunN
 * @date 2022/04/16
 */
public class FindFinalValue {

    public int findFinalValue(int[] nums, int original) {
        for (int num : nums) {
            if (num == original) {
                original = num * 2;
                return findFinalValue(nums, original);
            }
        }
        return original;
    }

    // [5,3,6,1,12]
    // 3

    // [8,19,4,2,15,3]
    // 2
    @Test
    public void test() {
        int[] nums = {8, 19, 4, 2, 15, 3};
        int original = 2;
        System.out.println(findFinalValue(nums, original));
    }

    @Test
    public void test1() {
        int num = 9;
        System.out.println(0);
        System.out.println(num % 10);
    }
}
