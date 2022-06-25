package com.yunn.autumn.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        canConstruct("789754731", "7897547318940");
    }

    @Test
    public void test1() {
        List<Integer> del = new ArrayList<>();
        List<Integer> db = new ArrayList<>();
        del.add(123);
        del.add(121);
        db.add(123);
        db.add(121);
        db.add(122);
        System.out.println(del.retainAll(db));

    }
}
