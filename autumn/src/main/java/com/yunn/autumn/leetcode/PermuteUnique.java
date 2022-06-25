package com.yunn.autumn.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yunN
 * @date 2022/06/01
 */
public class PermuteUnique {

    List<List<Integer>> rs = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        LinkedList<Integer> track = new LinkedList<>();
        Arrays.sort(nums);
        backtrack(nums, track, used);
        return rs;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
        if (track.size() == nums.length) {
            rs.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1] || used[i]) {
                continue;
            }
            track.addLast(nums[i]);
            used[i] = true;
            backtrack(nums, track, used);
            track.removeLast();
            used[i] = false;
        }
    }

    @Test
    public void test() {
        System.out.println(permuteUnique(new int[]{1, 2, 3}));
    }
}
