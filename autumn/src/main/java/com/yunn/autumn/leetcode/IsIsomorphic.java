package com.yunn.autumn.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yunN
 * @date 2022/04/18
 */
public class IsIsomorphic {

    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;

        int sLength = s.length();
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();
        for(int i = 0; i < sLength; i++){
            Character s1 = s2t.get(s.charAt(i));
            Character t1 = t2s.get(t.charAt(i));
            if ((s1 != null && s1 != t.charAt(i)) || (t1 != null && t1 != s.charAt(i))){
                return false;
            }
            s2t.put(s.charAt(i), t.charAt(i));
            t2s.put(t.charAt(i), s.charAt(i));
        }
        return true;
    }
}
