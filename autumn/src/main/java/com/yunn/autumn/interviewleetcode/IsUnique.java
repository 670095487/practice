package com.yunn.autumn.interviewleetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yunN
 * @date 2022/03/04.
 */
public class IsUnique {

    public static boolean isUnique(String str) {
        Map<String, Integer> res = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Integer num = res.getOrDefault(String.valueOf(str.charAt(i)), 0);
            if (num != 0) {
                return false;
            }
            res.put(String.valueOf(str.charAt(i)), 1);
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "zkz";
        System.out.println(isUnique(s));
    }
}
