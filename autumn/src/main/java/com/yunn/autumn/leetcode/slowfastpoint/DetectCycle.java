package com.yunn.autumn.leetcode.slowfastpoint;

import com.yunn.autumn.leetcode.ListNode;

/**
 * @author yunN
 * @date 2022/08/21
 */
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        // Set<ListNode> visited = new HashSet<>();
        // while (head != null && head.next != null) {
        //     if(visited.contains(head)){
        //         return head;
        //     }
        //     visited.add(head);
        //     head = head.next;
        // }
        // return null;

        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head, fast = head;
        // 确认是否有环
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;
        // 找到环起始点
        while (slow != fast) {
           slow = slow.next;
           fast = fast.next;
        }
        return slow;
    }
}
