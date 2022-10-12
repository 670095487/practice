package com.yunn.autumn.leetcode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yunN
 * @date 2022/10/10.
 */
public class CombinationSum3 {

    List<List<Integer>> ans;

    // backtrack
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.ans = new ArrayList<>();
        backtrack(k, n, 1, new LinkedList<>());
        return ans;
    }

    /**
     *
     * @param k k个数
     * @param target 目标和
     * @param start 每次回溯的开始位置
     * @param path 记录每一次回溯的完整路径
     */
    void backtrack(int k, int target, int start, LinkedList<Integer> path) {
        // 条件符合退出
        if (path.size() == k && target == 0) {
            ans.add(new LinkedList<>(path));
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (target - i < 0) {
                return;
            }
            path.add(i);
            backtrack(k, target - i, i + 1, path);
            path.removeLast();
        }
    }
}
