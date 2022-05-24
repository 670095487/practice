package com.yunn.autumn.leetcode;

import java.util.*;

/**
 * @author yunN
 * @date 2022/05/18
 */
public class FindDisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> full = new HashMap<>();
        for (int i = 1; i < len; i++) {
            full.put(i, 1);
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            full.put(nums[i], 0);
        }
        ArrayList<Integer> rs = new ArrayList<>();
        for (Map.Entry<Integer, Integer> en : full.entrySet()) {
            if (en.getValue() == 1){
                rs.add(en.getKey());
            }
        }
        return rs;
    }

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
