package com.yunn.autumn.leetcode.greedy;

/**
 * @author yunN
 * @date 2022/11/02.
 */
public class LC409 {

    public int longestPalindrome(String s) {
        int n = s.length();
        int[] count = new int[128];// 128位包含所有字符[ascii表]
        for (int i = 0; i < n; i++) {
            count[s.charAt(i)]++;
        }

        int ans = 0;
        for (int i : count) {
            ans += i / 2 * 2;// 回文，每一个字符使用次数为偶数
            if (i % 2 == 1 && ans % 2 == 0) {
                ans += 1;
            }
        }
        return ans;
    }
}
