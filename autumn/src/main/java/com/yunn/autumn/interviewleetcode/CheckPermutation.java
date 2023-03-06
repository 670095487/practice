package com.yunn.autumn.interviewleetcode;

import java.util.Arrays;

/**
 * @author yunN
 * @date 2022/03/04.
 * 判定是否为字符重排(2个字符串是相同字符组成的，但是顺序不一样)
 */
public class CheckPermutation {

    public static boolean checkPermutation(String s1, String s2) {
        // 将字符串转换成字符数组
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        // 对字符数组进行排序
        Arrays.sort(s1Chars);
        Arrays.sort(s2Chars);
        // 再将字符数组转换成字符串，比较是否相等
        return new String(s1Chars).equals(new String(s2Chars));
    }

    public static void main(String[] args) {
        System.out.println(checkPermutation("abc", "bca"));
    }
}
