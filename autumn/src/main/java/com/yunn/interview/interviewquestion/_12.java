package com.yunn.interview.interviewquestion;

/**
 * @date 2022/12/18
 */
public class _12 {

    char[][] boards;
    int m, n;

    // dfs + 剪枝
    public boolean exist(char[][] board, String word) {
        this.m = board.length;
        this.n = board[0].length;
        this.boards = board;
        char[] words = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, words, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, char[] words, int k) {
        // 上下左右四个方向dfs
        if (i < 0 || i > m || j < 0 || j > n || boards[i][j] != words[k]) return false;
        if (k == words.length - 1) {
            return true;
        }
        boards[i][j] = '\0';
        boolean res = dfs(i + 1, j, words, k + 1) || dfs(i - 1, j, words, k + 1)
                || dfs(i, j + 1, words, k + 1) || dfs(i, j - 1, words, k + 1);
        boards[i][j] = words[k];
        return res;
    }
}
