package com.yunn.interview.interviewquestion.d;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yunN
 * @date 2023/03/05.
 */
public class Combine2 {

    List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(0, candidates, target, 0, new LinkedList<>());
        return ans;
    }


    void backtrack(int starIndex, int[] nums, int target, int sum, LinkedList<Integer> sub) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            ans.add(new LinkedList<>(sub));
            return;
        }
        for (int i = starIndex; i < nums.length; i++) {
            // 去重
            if (i > starIndex && nums[i] == nums[i - 1]) continue;
            sub.addLast(nums[i]);
            sum += nums[i];
            backtrack(i + 1, nums, target, sum, sub);
            sum -= nums[i];
            sub.removeLast();
        }
    }
}
