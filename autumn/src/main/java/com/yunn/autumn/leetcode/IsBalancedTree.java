package com.yunn.autumn.leetcode;

/**
 * @author yunN
 * @date 2022/03/07
 */
public class IsBalancedTree {

    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * 本题中，一棵高度平衡二叉树定义为：
     * 一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1 。
     */

    boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return isBalanced;
    }

    int maxDepth(TreeNode node) {
        if (node == null) return 0;
        int lDepth = maxDepth(node.left);
        int rDepth = maxDepth(node.right);
        // 计算的顺带判断每一个节点是不是平衡的
        if (Math.abs(lDepth - rDepth) > 1) {
            isBalanced = false;
        }
        // 返回值没什么用
        return Math.max(lDepth, rDepth) + 1;
    }
}
