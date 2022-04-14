package com.yunn.autumn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yunN
 * @date 2022/04/05
 */
public class PreorderTraversal {

    // 根左右
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        result.add(root.val);
        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);
        result.addAll(left);
        result.addAll(right);
        return result;
    }

}


