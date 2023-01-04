package com.yunn.interview.interviewquestion.hot100;

import com.yunn.autumn.leetcode.ListNode;
import org.junit.Test;

/**
 * @author yunN
 * @date 2023/01/04.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            if (sum > 10) {
                carry = 1;
                sum = sum % 10;
            }
            cur.next = new ListNode(sum);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return pre.next;
    }

    @Test
    public void test() {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(8);
        l1.next.next = new ListNode(9);
        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(2);
        System.out.println(addTwoNumbers(l1, l2));

    }

}
