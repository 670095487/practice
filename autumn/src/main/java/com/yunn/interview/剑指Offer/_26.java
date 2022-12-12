package com.yunn.interview.剑指Offer;

import com.yunn.autumn.leetcode.TreeNode;

/**
 * @author yunN
 * @date 2022/12/12
 */
public class _26 {

    // 找到B节点在A节点中的位置 An
    // 判断从An开始到A_end是否包含B节点
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A != null && B != null) return true;
        return  (isSub(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    boolean isSub(TreeNode p, TreeNode s) {
        if (p == null) return false;
        if (s == null) return true;
        if (p != s) return false;
        return isSub(p.left, s.left) && isSub(p.right, s.right);
    }
}
