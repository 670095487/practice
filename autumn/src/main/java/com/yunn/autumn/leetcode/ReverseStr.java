package com.yunn.autumn.leetcode;

/**
 * @author yunN
 * @date 2022/07/01
 */
public class ReverseStr {

    public String reverseStr(String s, int k) {
        StringBuilder rs = new StringBuilder();
        if (s.length() < k) {
            return rs.append(s).reverse().toString();
        }
        String needReverse = s.substring(0, k);
        rs.append(needReverse).reverse().append(s.substring(k + 1));
        return rs.toString();
    }
}
