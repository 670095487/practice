package com.yunn.autumn.leetcode;

/**
 * @author yunN
 * @date 2022/03/03.
 * https://leetcode-cn.com/problems/same-tree/
 */
public class IsSameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

}
