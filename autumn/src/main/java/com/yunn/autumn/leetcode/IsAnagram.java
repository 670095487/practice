package com.yunn.autumn.leetcode;

import java.util.Arrays;

/**
 * @author yunN
 * @date 2022/04/25.
 */
public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        if (t.length() != s.length()) {
            return false;
        }
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        Arrays.sort(cs);
        Arrays.sort(ct);
        return Arrays.equals(cs, ct);
    }
}
