package com.yunn.autumn.leetcode;

import java.util.Arrays;

/**
 * LengthOfLastWord
 *
 * @author yunN
 * @createTime 2021年03月11日 10:16
 * @description 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。
 * 返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0。
 * <p>
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "Hello World"
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：s = " "
 * 输出：0
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {

        if (s == null || s.length() == 0 || s.trim().isEmpty()) return 0;

        String[] split = s.split("\\s+");

        return split[split.length - 1].length();
    }

    public static void main(String[] args) {
        String s = "hello world ";
        String[] split = s.split("\\s+");
        System.out.println(Arrays.toString(split));
    }


    /**
     * 不可使用 api
     *
     * @param s /
     * @return /
     */
    public int lengthOfLastWord2(String s) {

        int end = s.length() - 1;

        while (end >= 0 && s.charAt(end) == ' ') end--;

        if (end < 0) return 0;

        int start = end;

        while (start > 0 && s.charAt(start) != ' ') start--;

        return end - start;
    }
}
