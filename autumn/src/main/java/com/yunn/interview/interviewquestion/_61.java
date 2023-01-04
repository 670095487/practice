package com.yunn.interview.interviewquestion;

import java.util.HashSet;

/**
 * @date 2022/12/24
 */
public class _61 {

    // max - min < 5 && 无重复元素则是顺子
    public boolean isStraight(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int  min = 14, max = 0;
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            min = Math.min(min, num);
            max = Math.max(max, num);
            if (set.contains(num)) return false;
            set.add(num);
        }
        return max - min < 5;
    }
}
