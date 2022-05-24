package com.yunn.autumn.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yunN
 * @date 2022/05/07
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split("\\s+");

        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> pattern2s = new HashMap<>();
        Map<String, Character> s2Pattern = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            String currentStr = pattern2s.get(pattern.charAt(i));
            Character currentPattern = s2Pattern.get(words[i]);
            if (currentStr != null && !currentStr.equals(words[i])
                    || currentPattern != null && !currentPattern.equals(pattern.charAt(i))) {
                return false;
            } else {
                pattern2s.put(pattern.charAt(i), words[i]);
                s2Pattern.put(words[i], pattern.charAt(i));
            }
        }
        return true;
    }

    @Test
    public void test() {
        wordPattern("abba", "dog cat cat dog");
    }
}
