package com.yunn.autumn.leetcode;

/**
 * @author yunN
 * @date 2022/06/30
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 1. 找到了链表的中点
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //2. 将链表一分为二
        ListNode tmp = slow.next;
        slow.next = null;

        // 递归-问题拆解
        ListNode left = sortList(head);// 前半段
        ListNode right = sortList(tmp);// 后半段

        // 3. 按升序合并链表 -- 归并子步
        ListNode h = new ListNode(0);// 遍历使用
        ListNode rs = h;// 真正要返回的是rs.next , 因为rs的首位是0，不需要
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left; // 赋值
                left = left.next; // 指针后移
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        // 判断哪半段链表移到了尾部
        h.next = left != null ? left : right;
        return rs.next;

    }
}
