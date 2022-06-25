package com.yunn.autumn.leetcode;

import org.junit.Test;

/**
 * @author yunN
 * @date 2022/05/31
 */
public class SerachRange {

    // todo 时间复杂度
    public int[] searchRange(int[] nums, int target) {
        int[] rs = new int[2];
        int position = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (position == 1) {
                    rs[position] = i;
                } else {
                    rs[++position] = i;
                }
            }
        }

        if (position == -1) {
            rs[0] = -1;
            rs[1] = -1;
        } else if (position == 0) {
            rs[1] = rs [0];
        }

        return rs;
    }

    @Test
    public void test() {
        if (true ^ true) {
            System.out.println("baby");
        }else {
            System.out.println("dog");
        }
    }
}
