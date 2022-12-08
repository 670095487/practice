package com.yunn.interview.剑指Offer;

import org.junit.Test;

/**
 * @author yunN
 * @date 2022/12/08.
 */
public class _58 {

    public String reverseLeftWords(String s, int n) {
        String split = s.substring(0,n);
        StringBuilder ans = new StringBuilder();
        ans.append(s.substring(n)).append(split);
        return ans.toString();
    }

    @Test
    public void test() {
        System.out.println(reverseLeftWords("abcdef", 2));
    }
}
