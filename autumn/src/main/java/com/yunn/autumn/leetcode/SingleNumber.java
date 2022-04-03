package com.yunn.autumn.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yunN
 * @date 2022/03/19
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> intMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            intMap.merge(key, 1, Integer::sum);
        }

        for (Map.Entry<Integer, Integer> entry : intMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }
}
