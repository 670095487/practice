package com.yunn.interview.interviewquestion.d;

import org.junit.Test;

/**
 * @author yunN
 * @date 2023/02/14.
 */
public class MinWindow {

    /**
     * sliding-window
     * 1. 固定左边界，移动右边界，直到当前窗口恰好包含字符串t内所有字符
     * 2. 固定右边界，移动左边界，直到左边界向右移动一位以后，当前窗口恰好不满足包含字符串t内所有字符
     * 3. 计算并更新minWindow的值
     * ……重复123直到右边界到达字符串s的边界
     */
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        // corner case
        if (sLen == 0 || tLen == 0 || sLen < tLen) {
            return "";
        }
        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();

        // 记录滑动窗口内出现的字符的个数
        int[] winFreq = new int[128];
        // 记录t字符中每个字符出现的次数（是固定的）
        int[] tFreq = new int[128];
        for (char c : charArrayT) {
            tFreq[c]++;
        }

        // 定义滑动窗口内包含多少 t 中的字符，对应字符频数超过则不重复计算, 参考汉明距离的思想
        int distance = 0;
        int minLen = sLen + 1;
        int begin = 0;

        int left = 0;
        int right = 0;

        // 滑动窗口
        while (right < sLen) {
            // 如果当前字符并不在t中，则右边界++
            if (tFreq[charArrayS[right]] == 0) {
                right++;
                continue;
            }
            // 当前字符数t中的字符，则将其放入滑动窗口中,且如果当前winFreq中的这个字符数量是小于tFreq中的，distance需要++
            if (winFreq[charArrayS[right]] < tFreq[charArrayS[right]]) {
                distance++;
            }
            winFreq[charArrayS[right]]++;
            right++;

            // 说明当前滑动窗口包含了t中所有的字符，左窗口需要移动
            while (distance == t.length()) {

                // 维护minLen和左边界位置
                if (right - left < minLen) {
                    minLen = right - left;
                    begin = left;
                }

                // 如果当前字符并不在t中，则左边界++
                if (tFreq[charArrayS[left]] == 0) {
                    left++;
                    continue;
                }
                // 如果当前滑动窗口左边界出现的元素个数正好等于t窗口中左边界出现的元素个数时，distance--
                if (winFreq[charArrayS[left]] == tFreq[charArrayS[left]]) {
                    distance--;
                }
                // 移除左边界元素以后，滑动窗口中对应的左边界元素个数需要-1，同时左边界需要向右移动一位
                winFreq[charArrayS[left]]--;
                left++;

            }
        }
        return minLen == sLen + 1 ? "" : s.substring(begin, right);
    }

    private boolean isContains(String sub, String t) {
        int[] s_c = new int[128];
        int[] t_c = new int[128];
        for (char c : sub.toCharArray()) {
            int index = c - 'A';
            s_c[index]++;
        }
        for (char c : t.toCharArray()) {
            int index = c - 'A';
            s_c[index]--;
            if (s_c[index] < 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
