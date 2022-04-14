package com.yunn.autumn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yunN
 * @date 2022/04/06
 */
public class PostorderTraversal {

    // 左右根
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        List<Integer> lNodes = postorderTraversal(root.left);
        List<Integer> rNodes = postorderTraversal(root.right);
        result.addAll(lNodes);
        result.addAll(rNodes);
        result.add(root.val);
        return result;
    }
}
