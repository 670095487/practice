package com.yunn.autumn.leetcode;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * StrStr
 *
 * @author yunN
 * @createTime 2021年03月10日 11:27
 * @description 给定一个haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回 -1。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("all")
public class StrStr {
    /**
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     *
     * @param haystack /
     * @param needle   /
     * @return /
     */
    public int strStr(String haystack, String needle) {

        if (haystack.isEmpty() && !needle.isEmpty()) return -1;

        if (haystack.isEmpty()) return 0;

        int needleLength = needle.length();

        for (int i = 0; i < haystack.length(); i++) {

            if (needleLength + i > haystack.length()) return -1;
            if (haystack.substring(i, needleLength + i).equals(needle)) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 使用kmp算法实现string search
     */
    public int strSearchByKMP(String haystack, String needle) {


        return -1;
    }


    /**
     * 使用暴力遍历实现string search
     * 2021年05月08日23:04:30
     *
     * @param haystack 给定的源字符串
     * @param needle   待查找目标字符串
     */
    public int strSearchByCrash(String haystack, String needle) {
        //默认返回值
        int res = -1;
        //源字符串角标
        int sourceStrLength = haystack.length();
        //目标字符串角标
        int targetStrLength = needle.length();

        if (StringUtils.isEmpty(haystack) || StringUtils.isEmpty(needle) || needle.length() > haystack.length())
            return res;

        //已经遍历的次数 + 需要遍历的最大次数【即目标字符串的长度】<= 源字符串才有可能有解
        for (int i = 0; i + targetStrLength <= sourceStrLength; i++) {
            //是否匹配标志,需要在每次外层循环时重置值为true,否则只要内层改变了flag一次，后面flag就不会被还原为true
            boolean flag = true;
            //遍历次数最大即为目标字符串的长度，否则没有意义了 。
            for (int j = 0; j < targetStrLength; j++) {
                //源字符串的比较是每一次都是往后移动一位的，使用i作为记录下一次的起点，
                //i + j 代表本次循环和目标字符串同步的起点
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) return i;
        }
        return res;
    }

    /**
     * 暴力破解实现字符搜索
     */
    public int practiceForStringSearch(String sourceStr, String needleStr) {
        int res = -1;

        if (sourceStr.length() < needleStr.length() || StringUtils.isEmpty(sourceStr) || StringUtils.isEmpty(needleStr)) {
            return res;
        }

        int sourceStrLength = sourceStr.length();
        int needleStrLength = needleStr.length();

        /*
            1. 遍历源字符串，
         */
        for (int i = 0; i + needleStrLength < sourceStrLength; i++) {
            boolean flag = true;
            for (int j = 0; j < needleStrLength; j++) {
                if (sourceStr.charAt(i + j) != needleStr.charAt(j)) {
                    flag = false;
                    break;
                }
            }
           if (flag) return i;
        }
        return res;
    }

    @Test
    public void test1() {
        int i = practiceForStringSearch("hello", "ll");
        System.out.println(i);
    }
}
