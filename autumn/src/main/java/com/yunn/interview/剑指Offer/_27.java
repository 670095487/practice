package com.yunn.interview.剑指Offer;

import com.yunn.autumn.leetcode.TreeNode;
import org.junit.Test;

/**
 * @author yunN
 * @date 2022/12/12
 */
public class _27 {

    // 递归，从叶子节点开始翻转，最后交换根节点的左右子树即可
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    @Test
    public void test() {

    }
}
