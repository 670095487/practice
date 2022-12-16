package com.yunn.autumn.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @date 2022/12/15
 */
public class LC21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<Integer> list = new ArrayList<>();
        while (list1 != null && list1.next != null) {
            list.add(list1.val);
            list1 = list1.next;
        }

        while (list2 != null && list2.next != null) {
            list.add(list2.val);
            list2 = list2.next;
        }
        System.out.println(Arrays.toString(list.toArray()));
        Set<Integer> ans = list.stream().sorted().collect(Collectors.toSet());
        ListNode head = new ListNode(-1);
        ListNode dummy = head;
        for (Integer an : ans) {
            dummy.next = new ListNode(an);
        }

        return head.next;
    }
}
