package com.yunn.autumn.leetcode;

import org.junit.Test;

/**
 * @author yunN
 * @date 2022/05/16.
 */
public class AddStrings {

    public String addStrings(String num1, String num2) {
        long number1 = 0;
        // 222
        for (int i = 0; i < num1.length(); i++) {
            char ch = num1.charAt(i);
            if (Character.isDigit(ch)) {
                long s = Integer.parseInt(String.valueOf(ch));
                number1 = number1 * 10 + s;
            }
        }

        long number2 = 0;
        // 222
        for (int i = 0; i < num2.length(); i++) {
            char ch = num2.charAt(i);
            if (Character.isDigit(ch)) {
                long s = Integer.parseInt(String.valueOf(ch));
                number2 = number2 * 10 + s;
            }
        }
        return String.valueOf(number1 + number2);
    }

    @Test
    public void test() {
        // addStrings("122", "11");
        countSegments("  ");
    }

    public int countSegments(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;
        return s.split("\\s+").length;
    }
}
