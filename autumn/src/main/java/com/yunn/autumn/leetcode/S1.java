package com.yunn.autumn.leetcode;

/**
 * S1
 *
 * @author yunN
 * @createTime 2021年01月12日 23:02
 * @description 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class S1 {

    public static void main(String[] args) {
        int palindrome = 102201;
        if (ifIsPalindrome(palindrome)) {
            System.out.println("is a palindrome!");
        } else {
            System.out.println("is not a palindrome!");
        }

    }

    /**
     * 判断这个数字是否是一个回文数
     * 思路：
     * 1。将int转换为string,再将string转为char[]
     * 2。遍历char[],判断首/尾，首+1/尾-1，首+2/尾-2， 首+3/尾-3 …… 首+n/尾-n 是否都相等
     * 3。当首尾已经比较到了中间位置，循环应立即退出，无需再比。
     *
     * @param palindrome /
     * @return /
     */
    private static boolean ifIsPalindrome(int palindrome) {
        String palindromeStr = String.valueOf(palindrome);
        char[] chars = palindromeStr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i == chars.length - 1 - i) break;
            if (!(chars[i] == chars[chars.length - 1 - i])) return false;
        }
        return true;
    }
}
