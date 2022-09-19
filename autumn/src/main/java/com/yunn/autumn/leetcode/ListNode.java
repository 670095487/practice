package com.yunn.autumn.leetcode;

import lombok.Data;

/**
 * @author yunN
 * @date 2022/04/16.
 */
public class ListNode {
   public int val;
   public ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
