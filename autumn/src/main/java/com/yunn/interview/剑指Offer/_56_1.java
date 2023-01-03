package com.yunn.interview.剑指Offer;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author yunN
 * @date 2022/12/31.
 */
public class _56_1 {


    public int[] singleNumber1(int[] arr) {
        int ans = 0;
        for (int num : arr) {
            ans ^= num;
        }
        return new int[]{ans};
    }

    @Test
    public void test() {
        int[] arr = new int[]{2,2,3,3,1};
        System.out.println(Arrays.toString(singleNumber1(arr)));

    }
}
