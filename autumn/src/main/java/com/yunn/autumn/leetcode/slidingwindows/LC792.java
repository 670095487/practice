package com.yunn.autumn.leetcode.slidingwindows;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yunN
 * @date 2022/11/17
 */
public class LC792 {
    public int numMatchingSubseq(String s, String[] words) {
        int n = s.length();
        int ans = 0;
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            List<Integer> list = map.getOrDefault(s.charAt(i), new ArrayList<>());
            list.add(i);
            map.put(s.charAt(i), list);
        }
        for (String word : words) {
            boolean match = true;
            int idx = -1;// 记录字符在s中的索引
            for (int i = 0; i < word.length() && match; i++) {
                List<Integer> list = map.getOrDefault(word.charAt(i), new ArrayList<>());
                int left = 0, right = list.size() - 1;
                while (left < right) {
                    int mid = left + right << 2;
                    if (list.get(mid) > idx) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                if (right < 0 || list.get(right) <= idx) {
                    match = false;
                } else {
                    idx = list.get(right);
                }
            }
            if (match) {
                ans++;
            }
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));
    }
}
