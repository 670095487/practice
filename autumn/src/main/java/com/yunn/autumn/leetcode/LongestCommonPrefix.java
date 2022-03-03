package com.yunn.autumn.leetcode;

/**
 * LongestCommonPrefix
 *
 * @author yunN
 * @createTime 2021年01月17日 21:56
 * @description 在给出的一组字符串中匹配出共有的最长前缀
 */
@SuppressWarnings("all")
public class LongestCommonPrefix {

    /**
     * 1.遍历strs
     *
     * @param strs /
     * @return /
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        //取数组首元素
        String preStr = strs[0];
        //计算数组长度，确定遍历次数
        int count = strs.length;
        //首次计算 数组元素0与数组元素1 的最长公共前缀，后index依次横向往右移动
        for (int i = 1; i < count; i++) {
            preStr = longestCommonPrefix(preStr, strs[i]);
            //若最长公共前缀字符串的长度为0,则说明本组字符串无公共前缀,直接结束对本组字符串的计算
            if (preStr.length() == 0) {
                break;
            }
        }
        return preStr;
    }

    /**
     * 返回2个字符串的最长公共前缀
     *
     * @param preStr /
     * @param str    /
     * @return /
     */
    private String longestCommonPrefix(String preStr, String str) {
        //取两个字符串短者，公共前缀必然 <= 2个字符串中的最小字符串长度
        int minCount = Math.min(preStr.length(), str.length());
        //从 元素0开始逐渐后移比较
        int index = 0;
        //如果0 >= minCount 则说明最短的字符串是空串 或者是null 此种情况无需比较
        while (index < minCount && preStr.charAt(index) == str.charAt(index)) {
            index++;
        }
        //返回0～公共匹配长度
        return preStr.substring(0, index);
    }
}
