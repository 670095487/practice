package com.yunn.interview.剑指Offer;

import org.junit.Test;

/**
 * @author yunN
 * @date 2022/12/14.
 */
public class _47 {

    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        // right:(m,n-1),down:(m-1,n)
        // max = Math.max(right, down)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0 && j - 1 >= 0) {
                    dp[i][j] = Math.max(Math.max(dp[i - 1][j] + grid[i][j], grid[i][j]),
                            Math.max(dp[i][j - 1] + grid[i][j], grid[i][j]));
                } else if (i - 1 >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j] + grid[i][j], grid[i][j]);
                } else if (j - 1 >= 0) {
                    dp[i][j] = Math.max(dp[i][j - 1] + grid[i][j], grid[i][j]);
                } else {
                    dp[i][j] = grid[i][j];
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

    @Test
    public void test() {
        int[][] test = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        maxValue(test);
    }
}
