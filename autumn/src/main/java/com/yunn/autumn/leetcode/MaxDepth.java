package com.yunn.autumn.leetcode;

/**
 * @author yunN
 * @date 2022/03/04.
 */
public class MaxDepth {

    // dfs: 树左边最深为l, 右边最深为r 则此树的深度为 max(l,r) + 1
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int lHeight = maxDepth(root.left);
        int rHeight = maxDepth(root.right);
        return Math.max(lHeight, rHeight) + 1;
    }
}
