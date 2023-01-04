package com.yunn.interview.interviewquestion;

/**
 * @date 2022/12/19
 */
public class _13 {

    int m, n;
    boolean[][] visited;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.visited = new boolean[m][n];
        return dfs(0, 0, k);
    }

    // 上下左右四个方向  k <= i / 10 + i % 10 + j / 10 + j % 10
    private int dfs(int i, int j, int k) {
        // 边界条件
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || i / 10 + i % 10 + j / 10 + j % 10 > k) return 0;
        visited[i][j] = true;
        return dfs(i - 1, j, k) + dfs(i + 1, j, k) +
                dfs(i, j - 1, k) + dfs(i, j + 1, k) + 1;
    }
}
