package com.yunn.interview.剑指Offer;

import java.util.HashSet;

/**
 * @author yunN
 * @date 2022/12/08.
 */
public class _53_2 {

    public int missingNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max = nums.length + 1;
        for (int i = 0; i < max - 1; i++) {
            set.add(nums[i]);
        }
        for (int i = 0; i <= nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }
}
