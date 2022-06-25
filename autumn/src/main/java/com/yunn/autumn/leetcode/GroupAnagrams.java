package com.yunn.autumn.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yunN
 * @date 2022/06/06
 */
public class GroupAnagrams {

    List<List<String>> rs = new ArrayList<>();

    // ["eat","tea","tan","ate","nat","bat"]
    public List<List<String>> groupAnagrams(String[] strs) {
        boolean[] used = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if (used[i]) {
                continue;
            }
            List<String> single = new ArrayList<>();
            single.add(strs[i]);
            used[i] = true;
            for (int j = i + 1; j < strs.length; j++) {
                if (isGroupAnagrams(strs[i], strs[j])) {
                    used[j] = true;
                    single.add(strs[j]);
                }
            }
            rs.add(single);
        }
        return rs;
    }

    boolean isGroupAnagrams(String pre, String cur) {
        if (pre.length() != cur.length()) return false;

        int[] preArray = new int[26];
        for (int i = 0; i < pre.length(); i++) {
            preArray[pre.charAt(i) - 'a']++;
        }

        for (int i = 0; i < cur.length(); i++) {
            preArray[cur.charAt(i) - 'a']--;
            if (preArray[cur.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        // ["ddddddddddg","dgggggggggg"]
        // "eat","tea","tan","ate","nat","bat"
        System.out.println(isGroupAnagrams("eat", "aet"));
    }
}
