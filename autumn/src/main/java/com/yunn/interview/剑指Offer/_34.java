package com.yunn.interview.剑指Offer;

import com.yunn.autumn.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @date 2022/12/20
 */
public class _34 {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) return null;
        backtrack(root, target, new LinkedList<>());
        return ans;
    }

    void backtrack(TreeNode node, int target, LinkedList<Integer> path) {
        if (node == null) return;
        // 满足此条件说明当前路径已经到了叶子结点处,(左右子树都空)
        if (node.left == null && node.right == null) {
            if (target - node.val == 0) {
                path.addLast(node.val);
                ans.add(new LinkedList<>(path));
                path.removeLast();
                return;
            }
        }
        path.addLast(node.val);
        backtrack(node.left, target - node.val, path);
        // 回溯
        path.removeLast();

        path.addLast(node.val);
        backtrack(node.right, target - node.val, path);
        path.removeLast();
    }
}

