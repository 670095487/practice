package com.yunn.interview.interviewquestion.hot100;

import com.yunn.autumn.leetcode.TreeNode;

/**
 * @date 2023/01/15
 */
public class LowestCommonAncestor {


    // 分类讨论
    // 1. p or q 为空，返回p or q (不空的那个)
    // 2. 遍历
    //  2.1 在root的左子树中找p/q,找到则返回
    //  2.2 在root的右子树中找p/q,找到则返回
    //  2.3 在root的左右子树中都没找到p/q,则返回null
    //  2.4 如果分别在root的左右子树中找到了p,q,则直接返回root(root即为所求)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || q == root || p == root) return root;
        // s2
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        else if (left != null && right == null) return left;
        else if (left == null && right != null) return right;
        else return null;
    }
}
