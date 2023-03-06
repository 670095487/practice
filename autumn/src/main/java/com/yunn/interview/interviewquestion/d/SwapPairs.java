package com.yunn.interview.interviewquestion.d;

/**
 * @author yunN
 * @date 2023/02/17.
 */
public class SwapPairs {

    // 代码随想录 链表部分 看图写
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;// dummy始终指向待操作结点对的前一个结点
        ListNode cur = dummy;
        ListNode tmp;
        ListNode firstNode;
        ListNode secondNode;
        // 2个待交换结点不能为空
        while (cur.next != null && cur.next.next != null) {
            tmp = cur.next.next.next;
            firstNode = cur.next;
            secondNode = cur.next.next;
            cur.next = secondNode;
            secondNode.next = firstNode;
            firstNode.next = tmp;
            cur = firstNode;
        }
        return dummy.next;
    }
}
