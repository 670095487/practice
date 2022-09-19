package com.yunn.autumn.leetcode.dp;

import org.junit.Test;

import java.util.*;

/**
 * @author yunN
 * @date 2022/08/19
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int j = 1; j <= s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (dp[i] && set.contains(s.substring(i, j))) {
                    dp[j] = true;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[s.length()];
    }


    @Test
    public void test() {
        List<String> set = new ArrayList<>();

        set.add("leet");
        set.add("code");
        wordBreak("leetcode", set);
    }
}
