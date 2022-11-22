package com.yunn.autumn.leetcode.slidingwindows;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yunN
 * @date 2022/11/16.
 */
public class LC3 {

    // sliding-window
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int left = 0, ln = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < ln; i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            ans = Math.max(ans, i - left + 1);

        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }
}
