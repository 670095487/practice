package com.yunn.autumn.leetcode.backtrack;

import com.yunn.autumn.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yunN
 * @date 2022/08/01
 */
public class PathSum {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return ans;
        backtrack(new LinkedList<>(), root, targetSum);
        return ans;
    }

    void backtrack(LinkedList<Integer> sub, TreeNode node, int sum) {
        if (node == null) return;
        int remain = sum - node.val;
        if (node.left == null && node.right == null) {
            if (remain == 0) {
                // 当前结点就是目标路径最后一个结点
                sub.addLast(node.val);
                ans.add(new LinkedList<>(sub));
                sub.removeLast();
            }
            return;
        }
        sub.addLast(node.val);
        backtrack(sub, node.left, remain);
        sub.removeLast();

        sub.addLast(node.val);
        backtrack(sub, node.right, remain);
        sub.removeLast();
    }
}
