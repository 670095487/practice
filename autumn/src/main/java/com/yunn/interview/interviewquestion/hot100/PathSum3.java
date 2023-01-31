package com.yunn.interview.interviewquestion.hot100;

import com.yunn.autumn.leetcode.TreeNode;

/**
 * @author yunN
 * @date 2023/01/30.
 */
public class PathSum3 {

    int ans = 0, target;

    /*
        使用双重dfs,
            dfs1逐个扫描树中所有的结点
            dfs2从1中选中的结点向下dfs,找到等于target和的结点后,ans++
     */
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        dfs1(root);
        return ans;
    }

    private void dfs1(TreeNode root) {
        dfs2(root.left, root.val);
        dfs2(root.right, root.val);
        dfs1(root.left);
        dfs1(root.right);
    }

    private void dfs2(TreeNode root, long val) {
        if (val == target) ans++;
        if (root.left != null) dfs2(root.left, target + root.left.val);
        if (root.right != null) dfs2(root.right, target + root.right.val);
    }
}
