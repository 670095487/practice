package com.yunn.autumn.leetcode.dp;

/**
 * @author yunN
 * @date 2022/10/11
 */
public class MaximalSquare_221 {


    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];// 存放matrix中每一个元素为1的边的长度
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // dp第一个位置的值完全来自矩阵首个元素
                if (i == 0) {
                    dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                } else if (matrix[i][j] == '1') {
                    dp[i][j] = dp[i - 1][j] + 1;
                }
            }
        }

        int maxSide = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0) continue;
                int curHeight = dp[i][j];
                for (int k = j; k >= 0; k--) {
                    if (dp[i][k] == 0) break;
                    // 取长宽最小（拼正方形）为边
                    curHeight = Math.min(curHeight, dp[i][k]);
                    // 在合法的正方形边长中取最大值
                    maxSide = Math.max(Math.min(curHeight, j - k + 1), maxSide);
                }
            }
        }

        return maxSide * maxSide;
    }
}
