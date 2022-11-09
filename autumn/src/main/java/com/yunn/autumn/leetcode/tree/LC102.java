package com.yunn.autumn.leetcode.tree;

import com.yunn.autumn.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author yunN
 * @date 2022/11/03.
 */
public class LC102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();// 此时队列的长度就是当前层结点的个数
            List<Integer> subs = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                subs.add(curNode.val);
                if (curNode.left != null) {
                    // subs.add(curNode.left.val);
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    // subs.add(curNode.right.val);
                    queue.offer(curNode.right);
                }
            }
            ans.add(subs);
        }
        return ans;
    }
}
