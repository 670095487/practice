package com.yunn.interview.剑指Offer;

import com.yunn.autumn.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @date 2022/12/23
 */
public class _54 {

    List<Integer> list = new ArrayList<>();

    public int kthLargest(TreeNode root, int k) {
        if (root == null) return 0;
        dfs(root);
        System.out.println(Arrays.toString(list.toArray()));
        return list.get(list.size() - k);
    }

    void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        list.add(node.val);
        dfs(node.right);
    }
}
