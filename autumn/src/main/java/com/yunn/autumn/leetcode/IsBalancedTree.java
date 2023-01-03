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

    /**
     *
     * @date 2022/12/29
     */
    public boolean isBalanced2(TreeNode root) {
        return dfs(root) != -1;
    }

    // 后序遍历二叉树
    int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        // 如果有返回值是-1的结点，则会层层向上递归返回，避免重复计算
        if (left == -1 || right == -1) return -1;
        // 如果左右子树的高度差大于1则说明不是平衡二叉树，否则直接返回其高度
        return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
    }
}
