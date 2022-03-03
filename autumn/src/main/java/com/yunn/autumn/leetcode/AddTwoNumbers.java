package com.yunn.autumn.leetcode;

import org.junit.Test;

/**
 * Created by yunN on 2021/09/05
 * <p>
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbers {

    /**
     * 非空链表，除数字0以外，都不会以0开头，逆序求和
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                //head指向了tail节点的位置
                head = tail = new ListNode(sum % 10);
            } else {
                //对当前tail节点的next域赋值
                tail.next = new ListNode(sum % 10);
                //当前指向tail的指针后移一位[此时指针指向了tail.next的node]。
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    @Test
    public void testAddTwoNumbers() {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2, node1);
        ListNode node3 = new ListNode(6, node2);
        ListNode node4 = new ListNode(2, node2);
        //[6,7,10]
        //[7,10]
        //[3,8,1,1]
        System.out.println(addTwoNumbers(node3, node4));
    }

    public static void main(String[] args) {
        System.out.println(new ListNode(10).val);
        System.out.println(new ListNode(10).next);
    }
}
