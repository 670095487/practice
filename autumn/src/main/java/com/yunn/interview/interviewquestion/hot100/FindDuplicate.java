package com.yunn.interview.interviewquestion.hot100;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author yunN
 * @date 2023/01/11.
 */
public class FindDuplicate {

    // 二进制异或
    public int findDuplicate(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] ^ nums[i];
        }
        System.out.println(Arrays.toString(nums));
        return nums[nums.length - 1];
    }

    @Test
    public void test() {
        int[] ints ={2,3,5,4,3};
        findDuplicate(ints);
    }
}
