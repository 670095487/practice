package com.yunn.autumn.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yunN
 * @date 2022/04/16.
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> integerMap = new HashMap<>();
        for (int num : nums) {
            Integer pre = integerMap.get(num);
            if (pre == null) {
                integerMap.put(num, 1);
            } else {
                integerMap.put(num, ++pre);
            }
        }
        int max = 0;
        for (Integer value : integerMap.values()) {
            if (value > max) {
                max = value;
            }
        }

        for (Map.Entry<Integer, Integer> en : integerMap.entrySet()) {
            if (en.getValue() == max) {
                return en.getKey();
            }
        }
        return 0;
    }

    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    @Test
    public void test() {
        System.out.println(majorityElement1(new int[]{2, 1}));
    }
}

