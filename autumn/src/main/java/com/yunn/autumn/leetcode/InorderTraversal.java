package com.yunn.autumn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yunN
 * @date 2022/03/03.
 */
public class InorderTraversal {

    // 前序：根左右
    // 中序：左根右
    // 后序：左右根
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }
}
