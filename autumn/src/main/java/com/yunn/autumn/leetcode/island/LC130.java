package com.yunn.autumn.leetcode.island;

/**
 * @author yunN
 * @date 2022/11/21.
 */
public class LC130 {

    int m = 0, n = 0;
    boolean[][] visited;

    public void solve(char[][] board) {
        this.m = board.length;
        this.n = board[0].length;
        visited = new boolean[m][n];
        // 行固定，列从0->n-1
        for (int j = 0; j < n; j++) {
            dfs(board, true, 0, j);
            dfs(board, true, m - 1, j);
        }
        // 列固定，行从0->m-1
        for (int i = 0; i < m; i++) {
            dfs(board, true, i, 0);
            dfs(board, true, i, n - 1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    dfs(board, false, i, j);
                }
            }
        }
    }

    void dfs(char[][] b, boolean isEdge, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        if (visited[i][j] || b[i][j] != 'O') {
            return;
        }

        visited[i][j] = true;
        if (!isEdge) {
            b[i][j] = 'X';
        }
        dfs(b, isEdge, i + 1, j);
        dfs(b, isEdge, i - 1, j);
        dfs(b, isEdge, i, j - 1);
        dfs(b, isEdge, i, j + 1);
    }
}
