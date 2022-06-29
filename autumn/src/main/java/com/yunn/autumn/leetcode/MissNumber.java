package com.yunn.autumn.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yunN
 * @date 2022/05/03.
 */
public class MissNumber {

    public int missingNumber(int[] nums) {
        int len = nums.length + 1;
        Set<Integer> rs = new HashSet<>();
        // 全量的数据
        for (int i = 0; i < len; i++) {
            rs.add(i);
        }
        for (int num : nums) {
            rs.remove(num);
        }

        if (rs.isEmpty()) {
            return -1;
        }
        return (int)rs.toArray()[0];
    }

    @Test
    public void test() {
        System.out.println(missingNumber(new int[]{3, 1, 0}));
    }
}
