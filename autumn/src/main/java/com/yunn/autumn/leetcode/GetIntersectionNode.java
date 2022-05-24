package com.yunn.autumn.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yunN
 * @date 2022/04/15
 */
public class GetIntersectionNode {
    // 找到2个ListNode的相交结点
    // 返回相交的结点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        Map<ListNode, Boolean> booleanMap = new HashMap<>();
        while (headA != null) {
            booleanMap.put(headA, true);
            headA = headA.next;
        }
        while (headB != null) {
            if (booleanMap.containsKey(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
