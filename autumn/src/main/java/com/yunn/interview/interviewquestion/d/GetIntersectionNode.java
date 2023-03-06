package com.yunn.interview.interviewquestion.d;

/**
 * @author yunN
 * @date 2023/02/18.
 */
public class GetIntersectionNode {

    /**
     * 1. 先求出2个链表的长度
     * 2. 对齐2个链表的末尾
     * 3. 逐个比较
     *
     * 注意：相交并不是值相等，而是指针相等
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int na = 0, nb = 0;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != null) {
            na++;
            nodeA = nodeA.next;
        }
        while (nodeB != null) {
            nb++;
            nodeB = nodeB.next;
        }
        System.out.println("na = " + na + ", nb = " + nb);
        int longStart = Math.abs(na - nb);
        nodeA = headA;
        nodeB = headB;
        if (na >= nb) {
            for (int i = 0; i < na; i++) {
                nodeA = nodeA.next;
            }
        } else {
            for (int i = 0; i < nb; i++) {
                nodeB = nodeB.next;
            }
        }
        System.out.println(nodeA);
        System.out.println(nodeB);
        while (nodeA != null && nodeB != null) {
            if (nodeA == nodeB) {
                return nodeA;
            }
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return null;
    }
}
