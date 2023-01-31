package com.yunn.interview.interviewquestion.hot100;

import com.yunn.autumn.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yunN
 * @date 2023/01/30.
 */
public class PathSum2 {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return ans;
        }
        backtrack(root, targetSum, new LinkedList<>());
        return ans;
    }

    private void backtrack(TreeNode root, int targetSum, LinkedList<Integer> path) {
        if (root == null) return;
        int remain = targetSum - root.val;
        if (root.left == null && root.right == null) {
            if (remain == 0) {
                path.addLast(root.getVal());
                ans.add(new LinkedList<>(path));
                path.removeLast();
            }
        }
        path.addLast(root.val);
        backtrack(root.left, remain, path);
        path.removeLast();

        path.addLast(root.val);
        backtrack(root.right, remain, path);
        path.removeLast();
    }

}
