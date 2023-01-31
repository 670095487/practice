package com.yunn.interview.interviewquestion.hot100;

import com.yunn.autumn.leetcode.TreeNode;

import java.util.LinkedList;

/**
 * @author yunN
 * @date 2023/01/30.
 */
public class PathSum {

    public boolean hasPathSum(TreeNode node, int target) {
        if (node == null) return false;
        if (target == node.val && node.right ==null && node.left == null) {
            return true;
        }
        return hasPathSum(node.left, target-node.val) || hasPathSum(node.right,target-node.val);
    }
}
