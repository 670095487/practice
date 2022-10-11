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
            for (int j = i; j < n; j++) {
                // dp第一个位置的值完全来自于矩阵首个元素
                if (i == 0) {
                    dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                } else if (matrix[i][j] == '1') {
                    dp[i][j] = dp[i - 1][j] + 1;
                }
            }
        }


        return 0;
    }
}
