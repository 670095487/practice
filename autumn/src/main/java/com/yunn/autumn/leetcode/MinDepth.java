package com.yunn.autumn.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yunN
 * @date 2022/03/08
 */
public class MinDepth {

    /**
     * 循环条件：root.next != null，起点是root, 终点是最后一个叶子节点
     * 记录走的步数（深度）：int step = 0
     *
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> treeNodes = new LinkedList<>();
        // linklist对offer的实现就是 list.add()
        treeNodes.offer(root);
        int depth = 1;
        // 每执行一次while循环都表明 树的深度往下走了一步
        while (!treeNodes.isEmpty()) {
            int sz = treeNodes.size();
            // 开始对队列中所有元素进行循环
            for (int i = 0; i < sz; i++) {
                // 返回队列中第一个元素，并从队列中删除该元素
                TreeNode node = treeNodes.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                // 每次for循环结束会删除一个节点并新增一个节点，或者不新增，直到队列中所有节点都被遍历完成
                if (node.left != null) {
                    treeNodes.offer(node.left);
                }
                if (node.right != null) {
                    treeNodes.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
