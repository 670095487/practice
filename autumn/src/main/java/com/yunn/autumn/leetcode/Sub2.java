package com.yunn.autumn.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yunN
 * @date 2022/07/04.
 */
public class Sub2 {

    List<List<Integer>> rs = new ArrayList<>();

    int count = 0;
    // boolean[] used;

    // backtrack
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // this.used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(0, nums, new LinkedList<Integer>());
        return rs;

    }

    void backtrack(int start, int[] nums, LinkedList<Integer> sub) {

        rs.add(new LinkedList<>(sub));

        for (int i = start; i < nums.length; i++) {
            // 剪枝逻辑，值相同的相邻树枝，只遍历第一条 **
            if (i > start && nums[i] == nums[i - 1]) {
                System.out.println("i = " + i + " ,start = " + start);
                System.out.println("num[i] = " + nums[i] + ", num[i-1] = " + nums[i - 1]);
                System.out.println("----------------------");
                continue;
            }
            sub.add(nums[i]);
            backtrack(i + 1, nums, sub);
            sub.removeLast();
        }
    }

    @Test
    public void test() {
        subsetsWithDup(new int[]{1, 2, 2});
    }
}
