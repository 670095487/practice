package com.yunn.interview.interviewquestion.d;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yunN
 * @date 2023/02/21.
 */
public class TwoSum {

    /**
     * 直接做法：利用hashMap, key-数组的值，val-值对应在数组里的索引
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer tmp = map.get(target - nums[i]);
            if (tmp != null) {
                return new int[]{i, tmp};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
