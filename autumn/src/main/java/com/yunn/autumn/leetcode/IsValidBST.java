package com.yunn.autumn.leetcode;

/**
 * @author yunN
 * @date 2022/07/18.
 */
public class IsValidBST {

    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }

    boolean inorder(TreeNode node) {
        if (node == null) return true;
        boolean l = inorder(node.left);
        // 根<=左 则不合理，不是一个bst
        if (node.val <= pre) return false;
        pre = node.val;
        boolean r = inorder(node.right);
        return l && r;
    }
}
