package com.yunn.interview.interviewquestion;

import com.yunn.autumn.leetcode.TreeNode;

/**
 * @date 2022/12/29
 */
public class _68_1 {

    // 循环搜索： 当节点 root 为空时跳出；
    // 当 p,qp, qp,q 都在 root 的 右子树 中，则遍历至 root.right
    // 否则，当 p,qp, qp,q 都在 root 的 左子树 中，则遍历至 root.left
    // 否则，说明找到了 最近公共祖先 ，跳出。
    // 返回值： 最近公共祖先 root
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val) root = root.left;
            else if (root.val < p.val && root.val < q.val) root = root.right;
            else break;
        }
        return root;
    }
}
