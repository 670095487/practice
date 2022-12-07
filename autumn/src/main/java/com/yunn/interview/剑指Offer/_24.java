package com.yunn.interview.剑指Offer;

import com.yunn.autumn.leetcode.ListNode;

/**
 * @author yunN
 * @date 2022/12/07.
 */
public class _24 {

    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        return recursive(head, null);
    }

    // 1 -> 2 -> null
    // null = 2.next
    // null -> 2
    // recur(1, null->2)
    // null->2<-1
    // 1.next = null -> 2
    // tmp = null -> 2
    // tmp -> 1
    // null -> 2 -> 1
    ListNode recursive(ListNode cur, ListNode pre) {
        if (cur == null) return pre;
        ListNode rs = recursive(cur.next, cur);
        cur.next = pre;
        return rs;
    }
}
