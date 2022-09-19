package com.yunn.autumn.leetcode;

/**
 * @author yunN
 * @date 2022/08/10
 */
public class ClosedIsland {

    int m,n;
    int[][] grids;
    public int closedIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        grids = grid;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    count++;
                    dfs(i,j);
                }
            }
        }
        return count;
    }

    void dfs(int i, int j) {
        if (i >= m || i < 0 || j >= n || j < 0 || grids[i][j] != 0) {
            return;
        }
        grids[i][j] = 1;
        dfs(i+1,j);
        dfs(i-1,j);
        dfs(i,j-1);
        dfs(i,j+1);
    }
}
