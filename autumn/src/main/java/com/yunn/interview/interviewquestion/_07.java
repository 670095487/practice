package com.yunn.interview.interviewquestion;

import com.yunn.autumn.leetcode.TreeNode;

/**
 * @date 2022/12/30
 */
public class _07 {

    // pre-order:root->left->right
    // in-order:left->root->right
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }

    public TreeNode build(int[] pre, int[] in, int preL, int preR, int inL, int inR) {
        if (preL > preR || inL > inR || preL >= pre.length || inL >= in.length) {
            return null;
        }
        int rootVal = pre[preL];
        TreeNode rootNode = new TreeNode(rootVal);
        // 从中序序列中计算左子树的长度
        int leftLength = inL;
        while (in[leftLength] != rootVal) {
            leftLength++;
        }
        leftLength -= inL;
        rootNode.left = build(pre, in, preL + 1, preL + leftLength, inL, inL + leftLength - 1);
        rootNode.right = build(pre, in, preL + 1 + leftLength, preR, inL + leftLength + 1, inR);
        return rootNode;
    }
}
