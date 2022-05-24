package com.yunn.autumn.leetcode;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.*;

/**
 * @author yunN
 * @date 2022/05/11
 */
public class FirstUniqChar {

    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> rs = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer pre = rs.get(s.charAt(i));
            if (pre == null) pre = 0;
            rs.put(s.charAt(i), pre + 1);
        }

        for (Map.Entry<Character, Integer> en : rs.entrySet()) {
            if (en.getValue() == 1) {
                return s.indexOf(en.getKey());
            }
        }
        return -1;
    }

    public char findTheDifference(String s, String t) {
        int[] rs = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            rs[ch - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            rs[ch - 'a']--;
            if (rs[ch - 'a'] < 0) {
                return ch;
            }
        }

        return ' ';
    }

    @Test
    public void test() {
        System.out.println(firstUniqChar("leetcode"));
        findTheDifference("abcd", "abcde");
    }

    @Test
    public void test1() {
        String s = " ";
        String a = "";
        System.out.println(StringUtils.equals(s, a));
        StringUtils.isEmpty(s);
    }

    public int[] intersect(int[] nums1, int[] nums2) {

        List<Integer> rs = new ArrayList<>();
        if (nums2.length > nums1.length) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums1.length; i++) {
                Integer pre = map.get(nums1[i]);
                if (pre == null) pre = 0;
                map.put(nums1[i], pre + 1);
            }

            for (int i = 0; i < nums2.length; i++) {
                Integer pre = map.get(nums2[i]);
                if (pre != null && pre != 0) {
                    rs.add(nums2[i]);
                    map.put(nums2[i], pre - 1);
                }
            }
        } else {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums2.length; i++) {
                Integer pre = map.get(nums2[i]);
                if (pre == null) pre = 0;
                map.put(nums2[i], pre + 1);
            }
            for (int i = 0; i < nums1.length; i++) {
                Integer pre = map.get(nums1[i]);
                if (pre != null && pre != 0) {
                    rs.add(nums1[i]);
                    map.put(nums1[i], pre - 1);
                }
            }
        }


        int[] rsAarry = new int[rs.size()];
        for (int i = 0; i < rsAarry.length; i++) {
            rsAarry[i] = rs.get(i);
        }

        return rsAarry;
    }

    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }

    //"abc"
    // "ahbgdc"
    @Test
    public void test2() {
        System.out.println(isSubsequence("ab", "baab"));
    }
}
