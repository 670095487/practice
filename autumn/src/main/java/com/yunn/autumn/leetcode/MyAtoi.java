package com.yunn.autumn.leetcode;

import org.junit.Test;

/**
 * @author yunN
 * @date 2022/05/08
 */
public class MyAtoi {

    public int myAtoi(String s) {
        // 考虑corner case
        if (s == null) return 0;
        s = s.trim();
        if (s.isEmpty()) return 0;

        // 考虑第一个字符串：+/-？
        int idx = 0;
        int sign = 1;//标记此数是正数还是负数
        if (s.charAt(idx) == '+') {
            idx++;
        } else if (s.charAt(idx) == '-') {
            sign = -1;
            idx++;
            // 如果第一个字符不是数字，return 0
        } else if (!Character.isDigit(s.charAt(idx))) {
            return 0;
        }

        // 处理一般情况
        long num = 0;
        long res = 0;
        // 1. 不能越界；2.当前字符是数字
        while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
            num = num * 10 + Integer.parseInt(String.valueOf(s.charAt(idx)));
            res = num * sign;
            if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            idx++;
        }

        return (int) res;
    }

    public void reverseString(char[] s) {
        int len = s.length;
        int right = len - 1;

        for (int left = 0; left < right; ) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }

    @Test
    public void test() {
        System.out.println(myAtoi("9223372036854775808"));
    }
}
