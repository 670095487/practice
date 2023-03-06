package com.yunn.interview.interviewquestion.d;

/**
 * @author yunN
 * @date 2023/02/19.
 */
public class DetectCycle {


    /**
     * 1. 使用快慢指针，fast+2 slow+1, 能相遇则说明链表中存在环
     * 2. 确定有环以后，定义2个指针，一个指向链表开头结点，一个指向相遇结点
     * 3. 让第二步2个指针同步+1，相遇点就是环的入口
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        boolean isCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isCycle = true;
                break;
            }
        }
        if (isCycle) {
            ListNode start = head;
            ListNode meet = slow;
            while (start != meet) {
                start = start.next;
                meet = meet.next;
            }
            return start;
        }
        return null;
    }
}
