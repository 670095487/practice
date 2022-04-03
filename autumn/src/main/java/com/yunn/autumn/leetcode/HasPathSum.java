package com.yunn.autumn.leetcode;

/**
 * @author yunN
 * @date 2022/03/14
 */
public class HasPathSum {

    // 递归，一个节点一个节点的算
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        // 左右节点同时为Null，且根（此时这个节点实际就是叶子节点）的值等于递归最后一次的目标值
        if (targetSum == root.val && root.left == root.right) {
            return true;
        }

        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);
    }
}
