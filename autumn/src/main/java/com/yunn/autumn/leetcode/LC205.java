package com.yunn.autumn.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yunN
 * @date 2022/10/24.
 */
public class LC205 {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        int n = s.length();
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();
        for (int i = 0; i < n; i++) {
            s2t.put(s.charAt(i), t.charAt(i));
            t2s.put(t.charAt(i), s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            if (s2t.get(s.charAt(i)) != t.charAt(i) || t2s.get(t.charAt(i)) != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
