package com.yunn.interview.interviewquestion.d;

/**
 * @author yunN
 * @date 2023/02/18.
 */
public class RemoveNthFromEnd {

    /**
     * 暴力：扫描2遍，第一遍记录链表总长度，第二遍删除对应元素
     * Brute force solution 暴力解法
     */
    public ListNode removeNthFromEndBF(ListNode head, int n) {
        int totalNodes = -1;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode count = dummy;
        ListNode delete = dummy;
        while (count != null) {
            totalNodes++;
            count = count.next;
        }
        System.out.println(totalNodes);
        int index = totalNodes - n;
        System.out.println(index);
        // 移动到待删除结点的前驱结点
        for (int i = 0; i < index; i++) {
            delete = delete.next;
        }

        if (delete.next != null) {
            delete.next = delete.next.next;
        }

        return dummy.next;
    }

    // 双指针法：fast移动n步以后，slow fast 同时移动直到fast指向链表末尾，这时删除slow所指向的结点就可以
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = head;
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        // fast移动 n + 1步 , 这样slow下一阶段和fast同步移动时才能指向待删除结点的前驱结点
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // fast并不是移动到链表最后一个元素时停止，而是移动到链表最后一个元素的next时停止（即是null时停止）
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 删除目标结点
        slow.next = slow.next.next;
        return dummy.next;
    }
}
