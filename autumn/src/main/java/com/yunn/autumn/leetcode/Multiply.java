package com.yunn.autumn.leetcode;

import org.junit.Test;

/**
 * @author yunN
 * @date 2022/06/05
 */
public class Multiply {

    public String multiply(String num1, String num2) {
        int n = num1.length(), m = num2.length();
        int[] rs = new int[n + m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int multiply = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = rs[p2] + multiply;
                rs[p2] = sum % 10;
                rs[p1] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();

        boolean b = false;
        for (int i = 0; i < rs.length; i++) {
            if (rs[i] == 0 && !b){
                continue;
            }
            sb.append(rs[i]);
            b = true;
        }

        if (sb.length() == 0) return "0";

        return sb.toString();
    }

    @Test
    public void test() {
        System.out.println(multiply("123", "456"));
    }

    @Test
    public void test1() {
        String s = "23";
        char[] cs = new char[]{'a', 'b'};
        int a = s.charAt(0) - '0';
        int b = cs[0] - 'a';
        int c = cs[1] - 'a';
        System.out.println(a + "-" + b + "-" + c);
    }
}
