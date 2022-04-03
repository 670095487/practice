package com.yunn.autumn.leetcode;

/**
 * @author yunN
 * @date 2022/03/31
 */
public class HasCycle {

    public boolean hasCycle(ListNode head) {

        if (head == null) return false;

        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
