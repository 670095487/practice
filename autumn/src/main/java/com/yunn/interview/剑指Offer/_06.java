package com.yunn.interview.剑指Offer;

import com.yunn.autumn.leetcode.ListNode;
import org.junit.Test;

import java.util.LinkedList;

/**
 * @author yunN
 * @date 2022/12/07.
 */
public class _06 {

    LinkedList<Integer> list = new LinkedList<>();

    public int[] reversePrint(ListNode head) {
        recursive(head);
        int[] ans = new int[list.size()];
        while (!list.isEmpty()) {
            for (int i = 0; i < ans.length; i++) {
                ans[i] = list.pop();
            }
        }
        return ans;
    }

    void recursive(ListNode node) {
        if (node == null) {
            return;
        }
        list.push(node.val);
        recursive(node.next);
    }

    @Test
    public void test() {

    }
}
