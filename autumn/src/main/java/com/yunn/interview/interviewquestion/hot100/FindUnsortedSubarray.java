package com.yunn.interview.interviewquestion.hot100;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author yunN
 * @date 2023/02/06.
 */
public class FindUnsortedSubarray {

    /*
        将数组分成3段，arr_a, arr_b, arr_c
        arr_b就是所求（最短无序子序列）
     */
    public int findUnsortedSubarray(int[] nums) {
        int[] sorted = new int[nums.length];
        System.arraycopy(nums, 0, sorted, 0, nums.length);
        Arrays.sort(sorted);
        // 求最长arr_a
        int a_index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != sorted[i]) {
                a_index = i;
                break;
            }
        }
        // 求最长arr_c
        int c_index = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] != sorted[i]) {
                c_index = i;
                break;
            }
        }
        if (c_index == 0) return a_index + 1;
        return c_index - a_index + 1;
    }

    @Test
    public void test() {
        System.out.println(findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
    }
}
