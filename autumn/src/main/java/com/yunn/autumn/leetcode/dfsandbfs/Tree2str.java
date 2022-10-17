package com.yunn.autumn.leetcode.dfsandbfs;

import com.yunn.autumn.leetcode.TreeNode;

/**
 * @author yunN
 * @date 2022/10/16
 */
public class Tree2str {

    // pre-order : ROOT-LEFT-RIGHT
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.substring(1, sb.length() - 1);
    }

    void dfs(TreeNode root, StringBuilder sb) {
        sb.append("(");
        sb.append(root.val);
        if (root.left != null) {
            dfs(root.left, sb);
        } else if (root.right != null) {
            sb.append("()");
        }
        if (root.right != null) {
            dfs (root.right, sb);
        }
        sb.append(")");
    }
}
