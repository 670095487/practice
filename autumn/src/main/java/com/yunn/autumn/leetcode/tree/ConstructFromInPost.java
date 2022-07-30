package com.yunn.autumn.leetcode.tree;

import com.yunn.autumn.leetcode.dfsandbfs.TreeNode;

import java.util.HashMap;

/**
 * @author yunN
 * @date 2022/07/27
 * <p>
 * 从中后序构造二叉树
 */
public class ConstructFromInPost {

    HashMap<Integer, Integer> valToIndex = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }


    // 中序 9,3,15,20,7
    // 后序 9,15,7,20,3
    public TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {

        if (inStart > inEnd) {
            return new TreeNode();
        }

        if (inStart == inEnd) {
            return new TreeNode(inorder[inStart]);
        }

        // 后序遍历的最后一个结点是根节点
        int rootVal = postorder[postEnd];
        // 找到根节点在中序遍历中的位置
        int index = valToIndex.get(rootVal);
        // 计算当前根节点左子树的长度
        int leftSize = index - inStart;
        // 先构造根结点
        TreeNode root = new TreeNode(rootVal);
        root.left = build(inorder, inStart, index - 1, postorder, postStart, postStart + leftSize - 1);
        root.right = build(inorder, index + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);
        return root;
    }
}
