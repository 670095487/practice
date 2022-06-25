package com.yunn.autumn.leetcode;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yunN
 * @date 2022/06/25
 */
public class FindRelativeRanks {

    public String[] findRelativeRanks(int[] score) {
        List<Integer> cp = Arrays.stream(score).boxed().collect(Collectors.toList())
                .stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        String[] rs = new String[score.length];
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < cp.size(); i++) {
            if (i == 0) {
                map.put(cp.get(0), "Gold Medal");
            } else if (i == 1) {
                map.put(cp.get(1), "Silver Medal");
            } else if (i == 2) {
                map.put(cp.get(2), "Bronze Medal");
            } else {
                map.put(cp.get(i), String.valueOf(i + 1));
            }
        }
        for (int i = 0; i < score.length; i++) {
            rs[i] = map.get(score[i]);
        }
        return rs;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(findRelativeRanks(new int[]{10,3,8,9,4})));
    }

    List<List<Integer>> rs = new ArrayList<>();

    // backtrack 需要剪枝
    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> sub = new LinkedList<>();
        backtrack(0, nums, sub);
        return rs;
    }

    void backtrack(int start, int[] nums, LinkedList<Integer> sub){

        rs.add(new LinkedList<>(sub));

        for (int i = start; i < nums.length; i++) {
            // make
            sub.add(nums[i]);
            // backtrack
            backtrack(i+1, nums, sub);
            // cancel
            sub.removeLast();
        }
    }

    @Test
    public void test1() {
        subsets(new int[]{1,2,3});
    }

}
