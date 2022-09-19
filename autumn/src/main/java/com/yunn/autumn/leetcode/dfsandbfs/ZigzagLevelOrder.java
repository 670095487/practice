package com.yunn.autumn.leetcode.dfsandbfs;

import com.yunn.autumn.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yunN
 * @date 2022/07/25
 */
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        boolean flag = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int lvSize = queue.size();
            LinkedList<Integer> sub = new LinkedList<>();
            for (int i = 0; i < lvSize; i++) {
                TreeNode node = queue.poll();
                if (flag) {
                    sub.addLast(node.val);
                } else {
                    sub.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                flag = !flag;
            }
            ans.add(sub);
        }
        return ans;
    }
}
