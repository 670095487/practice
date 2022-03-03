package com.yunn.autumn.leetcode;

import org.junit.Test;

/**
 * MergeTwoLists
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }

        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public ListNode mergeTwoListsUseIteration(ListNode list1, ListNode list2) {

        ListNode preNode = new ListNode(-1);

        ListNode pre = preNode;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
               pre.next = list1;
               list1 = list1.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }

        pre.next = list1 == null ? list2 : list1;

        return preNode.next;
    }

    @Test
    public void testMergeTwoLists() {

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
