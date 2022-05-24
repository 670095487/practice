package com.yunn.autumn.leetcode;

import org.junit.Test;

/**
 * @author yunN
 * @date 2022/05/11
 */
public class CanConstruct {


    // ransomNote = "aa", magazine = "aab"
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (char c : magazine.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            cnt[c - 'a']--;
            if(cnt[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }


    @Test
    public void test() {
        canConstruct("aa", "aab");
    }

    @Test
    public void test1() {
        int a = 'b' - 'a';
        System.out.println(a);
    }
}
