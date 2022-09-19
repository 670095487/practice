package com.yunn.autumn.leetcode.dfsandbfs;

import com.yunn.autumn.leetcode.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yunN
 * @date 2022/07/24
 */
public class LvOrder {


    // BFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        while (!qu.isEmpty()) {
            List<Integer> lv = new ArrayList<>();
            int lvSize = qu.size();
            for (int i = 0; i < lvSize; i++) {
                TreeNode node = qu.poll();
                lv.add(node.val);
                if (node.left != null) {
                    qu.offer(node.left);
                }
                if (node.right != null) {
                    qu.offer(node.right);
                }
            }
            ans.add(lv);
        }
        return ans;
    }

    @Test
    public void test() {
        levelOrder(new TreeNode(1));
    }
}
