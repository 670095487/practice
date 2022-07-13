package com.yunn.autumn.leetcode;

import org.junit.Test;

/**
 * @author yunN
 * @date 2022/07/07
 */
public class ReverseWords {

    public String reverseWords(String s) {
        String[] split = s.split("\\s+");
        StringBuilder res = new StringBuilder();
        for (String value : split) {
            StringBuilder rs = new StringBuilder();
            rs.append(value).reverse();
            res.append(rs).append(" ");
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    @Test
    public void test() {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

}
