package com.yunn.interview.interviewquestion;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yunN
 * @date 2022/12/10
 */
public class _50 {

    public char firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer val = map.getOrDefault(c, 0);
            map.put(c, ++val);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return ' ';
    }

    @Test
    public void test() {
        System.out.println(firstUniqChar("loveleetcode"));
    }
}
