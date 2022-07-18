package com.yunn.autumn.leetcode;

import org.junit.Test;

/**
 * @author yunN
 * @date 2022/07/18
 */
public class IsInterleave {

    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();

        // 长度不等，s3就不可能由s1和s2组成
        if (n + m != t) {
            return false;
        }

        // 从下标1,1开始才是有效坐标，所以数组长度需要+1
        boolean[][] f = new boolean[n + 1][m + 1];
        f[0][0] = true;
        // 状态转移方程，f(i)(j) = f(i)(j-1) + f(i-1)(j)，拆成了2个子问题。
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                // 代表这个字符在s3中的位置
                int p = i + j - 1;
                // 分为2个情况，i > 0就从 i > 0的这边开始递归累计子结果
                if (i > 0) {
                    // c1: 当前位置默认值为false，c2:上一个位置值（t or f）, c3: 当前位置下，s3的值是否和s1的值相等
                    f[i][j] = f[i][j] || (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }

                if (j > 0) {
                    f[i][j] = f[i][j] || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }
        return f[n][m];
    }

    // "aabcc"
    // "dbbca"
    // "aadbbcbcac"

    @Test
    public void test() {
        isInterleave("aabcc", "dbbca", "aadbbcbcac");
    }
}
