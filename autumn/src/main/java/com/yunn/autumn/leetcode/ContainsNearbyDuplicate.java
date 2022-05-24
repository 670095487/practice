package com.yunn.autumn.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yunN
 * @date 2022/04/19
 */
public class ContainsNearbyDuplicate {
    //给你一个整数数组nums 和一个整数k ，判断数组中是否存在两个 不同的索引i和j ，
    // 满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。


    //nums=[1,0,1,1] k=1
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int i = 0;
        int len = nums.length;
        // val - index
        Map<Integer, Integer> result = new HashMap<>();
        while (i < len) {
            if (result.containsKey(nums[i]) && Math.abs(i - result.get(nums[i])) <= k) {
                return true;
            }
            result.put(nums[i], i);
            i++;
        }
        return false;
    }
}
