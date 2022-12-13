package com.yunn.interview.剑指Offer;

import com.yunn.autumn.leetcode.TreeNode;

/**
 * @author yunN
 * @date 2022/12/12
 */
public class _28 {

    // 镜像翻转，判等
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return check(root, root);
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}
