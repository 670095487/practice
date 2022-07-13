package com.yunn.autumn.leetcode;

import org.junit.Test;

/**
 * @author yunN
 * @date 2022/07/11
 */
public class ReverseBetween {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        // 截断链表
        ListNode leftNode = pre.next;
        pre.next = null;
        // 保留rightNode的下一个结点
        ListNode curr = rightNode.next;
        rightNode.next = null;

        reverse(leftNode);
        System.out.println(leftNode.toString());

        // 拼接链表
        pre.next = rightNode;
        leftNode.next = curr;
        return dummy.next;
    }


    ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp; // 指针已经后移
        }
        return pre; // 反转前，pre(null)->cur ，反转后， cur(null)->pre
    }

    @Test
    public void test() {

    }
}
