package com.yunn.interview.interviewquestion.d;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yunN
 * @date 2023/03/05.
 */
public class CombinationSum {

    List<List<Integer>> ans = new ArrayList<>();
    int[] nums;
    int target;

    // candidates内所选元素可以重复，目标和等于target就可以
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.nums = candidates;
        this.target = target;
        backtrack(0, new LinkedList<>(), 0);
        return ans;
    }

    // 因为取值是来自同一个集合，所以需要startIndex来控制横向for循环的起点
    // 如果取值是来自不同集合，那么就不需要这样一个startIndex
    void backtrack(int sum, LinkedList<Integer> sub, int start) {
        // 剪枝
        if (sum > target) {
            return;
        }

        if (sum == target) {
            ans.add(new LinkedList<>(sub));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            sub.add(nums[i]);
            sum += nums[i];
            backtrack(sum, sub, i);
            sub.removeLast();
            sum -= nums[i];
        }
    }

    @Test
    public void test() {
        int[] arr = new int[]{2, 2, 3, 7};
        System.out.println(combinationSum(arr, 7));
    }
}
