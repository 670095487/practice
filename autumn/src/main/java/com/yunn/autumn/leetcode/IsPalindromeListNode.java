package com.yunn.autumn.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yunN
 * @date 2022/04/23
 */
public class IsPalindromeListNode {

    public boolean isPalindrome(ListNode head) {
        ListNode low = head, fast = head;
        List<Integer> rs = new ArrayList<>();
        while (head != null) {
            rs.add(head.val);
            head = head.next;
        }

        for (int i = 0; i < rs.size(); i++) {
            if (rs.get(i) != rs.get(rs.size() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        int[] arr = {};
        int length = arr.length;
    }
}
