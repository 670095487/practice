package com.yunn.interview.interviewquestion.hot100;

import org.junit.Test;

/**
 * @author yunN
 * @date 2023/01/11.
 */
public class FindDuplicate {

    // 使用LC142环形链表的思想
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast) {
            slow = nums[slow]; // 类似链表中的node = node.next;
            fast = nums[nums[fast]]; // 类似链表中的node = node.next.next
        }
        int pre1 = 0, pre2 = slow; 
        while (pre1 != pre2) {
            pre1 = nums[pre1];
            pre2 = nums[pre2];
        }
        return pre1;
    }

    @Test
    public void test() {
        int[] ints ={2,3,5,4,3};
        findDuplicate(ints);
    }
}
