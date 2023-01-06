package com.yunn.interview.interviewquestion.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yunN
 * @date 2023/01/05.
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, ans = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                // 左指针移动到当前重复的位置
                left = Math.max(left, map.get(chars[i]) + 1);
            }
            map.put(chars[i], i);
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }
}
