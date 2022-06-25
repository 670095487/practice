package com.yunn.autumn.leetcode;

import org.junit.Test;

/**
 * @author yunN
 * @date 2022/06/09
 */
public class CanJump {

    public boolean canJump(int[] nums) {
        int farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int step = nums[i];
            farthest = Math.max(farthest, i + step);

            if (farthest == i) {
                return false;
            }
        }
        return farthest >= nums.length - 1;
    }

    @Test
    public void test() {
        System.out.println(canJump(new int[]{2, 0, 0}));
    }


}
