package com.yunn.interview.interviewquestion.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @date 2023/01/31
 */
public class FindAnagrams {


    /*
        暴力搜索
            1.s.for
            2.从s_i开始匹配i+p.length-1，是否和s所包含字符相同 (时间复杂度o(n^2))

        滑动窗口
     */
    char[] p_arr;
    public List<Integer> findAnagrams_Search(String s, String p) {
        p_arr = p.toLowerCase().toCharArray();
        List<Integer> ans = new ArrayList<>();
        int low = 0, high = low + p.length() - 1;
        while (high < s.length()) {
            String sub = s.substring(low, high + 1);
            System.out.println(sub);
            if (isSameString(sub)) {
                ans.add(low);
            }
            low++;
            high++;
        }
        return ans;
    }

    private boolean isSameString(String sub) {
        Arrays.sort(p_arr);
        char[] subs = sub.toLowerCase().toCharArray();
        Arrays.sort(subs);
        return Arrays.equals(p_arr,subs);
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int sLen = s.length(), pLen = p.length();
        if (sLen < pLen) {
            return ans;
        }
        // 定义数组用来记录原始字符和窗口内字符
        int[] sCount = new int[26];
        int[] pCount = new int[26];

        // 初始化第一个窗口,第一个窗口内的字符串就是s的[0, p.len - 1]位
        for (int i = 0; i < p.length(); i++) {
            ++sCount[s.charAt(i)-'a']; //记录s中前pLen个字母的词频
            ++pCount[p.charAt(i)-'a']; //记录要寻找的字符串中每个字母的词频(只用进行一次来确定)
        }

        // 判断第一个窗口内的值是否和p相等
        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        // 开始滑动窗口
        for (int i = 0; i < sLen - pLen; i++) {
            // 滑动窗口第一位移出窗口
            --sCount[s.charAt(i)-'a'];
            // 滑动窗口往后移动一位
            ++sCount[s.charAt(i+pLen) -'a'];

            // 判断当前窗口是否和pCount相等
            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;
    }

}
