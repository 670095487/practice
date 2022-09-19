package com.yunn.autumn.leetcode.linkedlist;

import com.yunn.autumn.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yunN
 * @date 2022/08/22
 */
public class ReOrderList {

    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node.next != null) {
            list.add(node);
            node = node.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
    }
}
