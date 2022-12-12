package com.yunn.interview.剑指Offer;

import com.yunn.autumn.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author yunN
 * @date 2022/12/11.
 */
public class _32_1 {

    public int[] levelOrder(TreeNode root) {
        Deque<TreeNode> que = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        que.offer(root);
        while (!que.isEmpty()){
            TreeNode curNode = que.pop();
            list.add(curNode.val);
            if (curNode.left != null) {
                que.offer(curNode.left);
            }
            if (curNode.right != null) {
                que.offer(curNode.right);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
