package com.yunn.interview.剑指Offer;

import com.yunn.autumn.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yunN
 * @date 2022/12/12.
 */
public class _32_3 {

    // 之形输出结点
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        // t-(l->r),f-(r->l)
        boolean leftOrRight = true;
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            ArrayList<Integer> list = new ArrayList<>();
            if (leftOrRight){
                leftOrRight = false;
                for (int i = 0; i < size; i++) {
                    TreeNode cur = deque.pop();
                    list.add(cur.val);
                    if (cur.left != null) {
                        deque.offer(cur.left);
                    }
                    if (cur.right != null) {
                        deque.offer(cur.right);
                    }
                }
                ans.add(list);
            }else {
                leftOrRight = true;
                for (int i = 0; i < size; i++) {
                    TreeNode cur = deque.pop();
                    list.add(cur.val);
                    if (cur.left != null) {
                        deque.offer(cur.left);
                    }
                    if (cur.right != null) {
                        deque.offer(cur.right);
                    }
                }
                ArrayList<Integer> reverseList = new ArrayList<>();
                for (int i = list.size() - 1; i >= 0; i--) {
                    reverseList.add(list.get(i));
                }
                ans.add(reverseList);
            }
        }
        return ans;
    }
}
