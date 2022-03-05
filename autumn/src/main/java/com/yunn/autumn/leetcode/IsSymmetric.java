package com.yunn.autumn.leetcode;

/**
 * @author yunN
 * @date 2022/03/04.
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return check(root.left, root.right);
        }
    }

    boolean check(TreeNode left, TreeNode right) {
        if (left == null || right == null) return left == right;
        if (left.val != right.val) return false;
        return check(left.right, right.left) && check(left.left, right.right);
    }
}
