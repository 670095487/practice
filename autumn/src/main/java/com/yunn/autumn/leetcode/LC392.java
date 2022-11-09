package com.yunn.autumn.leetcode;

/**
 * @author yunN
 * @date 2022/10/24.
 */
public class LC392 {

    public boolean isSubsequence(String s, String t) {
        // 1. 子序列中所有的字符串需要都在父字符串中
        // 2. 子序列的字符顺序需要和父字符串的字符顺序保持一致
        // 思路：定义i j 分别记录s和t的索引，每次找到对应的字符时，检查j当前的值是否大于上一次j的值
        if (t.length() == 0) return false;
        int i = 0, j = 0;
        int n = s.length();
        int pre = -1;
        for (i = 0; i < n; i++) {
            for (j = 0; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    if (j > pre) {
                        pre = j;
                        break;
                    } else {
                        return false;
                    }
                }
                if (j == t.length() -1) return false;
            }
        }
        return true;
    }
}
