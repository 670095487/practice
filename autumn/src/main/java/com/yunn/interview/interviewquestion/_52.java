package com.yunn.interview.interviewquestion;

import com.yunn.autumn.leetcode.ListNode;

/**
 * @date 2022/12/16
 */
public class _52 {

    //“我走过我的世界，再从你的世界走一遍”
    //“你走过你的世界，再从我的世界走一遍”
    //“最终我们将相遇，可能在途中（公共节点），可能在结尾（null）”
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB ==null) return null;
        ListNode dummy_a = headA, dummy_b = headB;
        while (dummy_a != dummy_b) {
            dummy_a = dummy_a != null ? dummy_a.next : headB;
            dummy_b = dummy_b != null ? dummy_b.next : headA;
        }
        return dummy_a;
    }
}
