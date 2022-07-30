package com.yunn.autumn.leetcode.tree;

import com.yunn.autumn.leetcode.dfsandbfs.TreeNode;

import java.util.HashMap;

/**
 * @author yunN
 * @date 2022/07/26
 */
public class ConstructFromPreIn {

    HashMap<Integer, Integer> valToIndex = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }

        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        // 前序遍历的第一个结点就是根结点
        int rootVal = preorder[preStart];
        // 左子树在中序结点的位置
        int index = valToIndex.get(rootVal);
        // 左子树的长度
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootVal);
        // index左边 是左子树
        root.left = build(
                preorder/*前序树*/,
                preStart + 1/*第一个是根，所以+1*/,
                preStart + leftSize/*左子树的最大长度*/,
                inorder/*中序树*/,
                inStart/**/,
                index - 1/**/
        );
        // index右边 是右子树
        root.right = build(preorder, preStart + leftSize + 1/*右子树起点*/, preEnd, inorder, index + 1, inEnd);
        return root;
    }
}
