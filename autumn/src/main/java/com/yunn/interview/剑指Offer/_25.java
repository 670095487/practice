package com.yunn.interview.剑指Offer;

import com.yunn.autumn.leetcode.ListNode;

/**
 * @date 2022/12/16
 */
public class _25 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode dummy = head;
        while (l1 != null && l2 != null ) {
            if (l1.val >= l2.val) {
                dummy.next = l2;
                l2 = l2.next;
            } else {
                dummy.next = l1;
                l1 = l1.next;
            }
            dummy = dummy.next;//每一次判断以后dummy都会指向了一个新的结点，所以在指向了新结点以后，dummy需要往后移动一位，否则已更新的结点都会被下一次更新掉
        }
        dummy.next = l1 == null ? l2 : l1;
        return head.next;
    }
}
