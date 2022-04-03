package com.yunn.autumn.leetcode;

/**
 * @author yunN
 * @date 2022/03/19
 */
public class IsPalindrome {

    public boolean isPalindrome(String s) {
        StringBuilder sbf = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                sbf.append(s.charAt(i));
            }
        }
        StringBuffer reverse = new StringBuffer(sbf).reverse();
        return sbf.toString().equalsIgnoreCase(reverse.toString());
    }
}
