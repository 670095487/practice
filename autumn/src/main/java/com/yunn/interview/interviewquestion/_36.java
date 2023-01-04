package com.yunn.interview.interviewquestion;


/**
 * @date 2022/12/20
 */
public class _36 {

    Node pre,head;

    // 1. 中序遍历二叉树得到有序序列
    // 2. 双向循环链表
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs(Node cur) {
        if (cur == null) return;
        dfs(cur.left);
        // 处理逻辑
        if (pre != null) {
            pre.right = cur;
        } else {
            // pre为null说明是第一次遍历，head需要初始化为当前结点
            head = cur;
        }
        cur.left = pre;
        // pre后移
        pre = cur;
        dfs(cur.right);
    }
}
