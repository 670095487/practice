package com.yunn.interview.interviewquestion.hot100;

import org.junit.Test;

/**
 * @date 2023/01/13
 */
public class LongestValidParentheses {

    // dp
    // dp[i]定义的是第i位，有效括号对的数目，
    public int longestValidParentheses(String s) {
        int n = s.length();
        // 定义dp数组
        int[] f = new int[n];
        int ans = 0;
        for (int i = 1; i < n; i++) {
            // 分情况讨论
            // 1. 第i位是')',
            //  1.1 第i-1位是'(',
            //  1.2 第i-1位是')'
            //    1.2.1 i - dp[i-1] - 1是'('
            //     1.2.1.1 i - dp[i-1] -1 -1 >= 0, dp[i] = dp[i-1]+2+dp[i-dp[i-1]-2] else
            //                                      dp[i] = dp[i-1]+2
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    f[i] = (i - 2 >= 0 ? f[i - 2] : 0) + 2;
                } else if (i - f[i - 1] > 0 && s.charAt(i - f[i - 1] - 1) == '(') {
                    f[i] = f[i - 1] + 2 + (i - f[i - 1] - 2 >= 0 ? f[i - f[i - 1] - 2] : 0);
                }
            }
            ans = Math.max(f[i], ans);
        }
        return ans;
    }


    @Test
    public void test() {
        longestValidParentheses("(()())");
    }
}
