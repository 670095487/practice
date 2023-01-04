package com.yunn.interview.interviewquestion;

import java.util.HashMap;

/**
 * @date 2022/12/15
 */
public class _48 {

    // sliding-window
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int ans = 0, left = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);//left重复位置右移1位
            }
            map.put(s.charAt(i), i);
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }
}
