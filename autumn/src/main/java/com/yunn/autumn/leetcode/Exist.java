package com.yunn.autumn.leetcode;

/**
 * @author yunN
 * @date 2022/06/26.
 */
public class Exist {

    int m;
    int n;
    int wordLength;
    String w;
    boolean[][] visited;
    char[][] board;

    public boolean exist(char[][] board, String word) {
        this.m = board.length;
        this.n = board[0].length;
        this.wordLength = word.length();
        this.visited = new boolean[m][n];
        this.board = board;
        this.w = word;
        // 遍历矩阵，矩阵的任何一个位置都可能是起点，
        // 只要能从矩阵的任何一个位置去找到符合条件的字符串就算成功
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean res = search(i, j, 0);
                if (res) return true;
            }
        }
        return false;
    }

    private boolean search(int i, int j, int k) {
        // 当前搜索字符的index已经到了最后（最大的index应该是wordLength-1）
        if (k >= wordLength) return true;

        if (
            // 回溯有可能发生超出矩阵边界的情况

                i < 0
                        || i >= m
                        || j < 0
                        || j >= n
                        // 如果当前字符不等于当前矩阵字符 可以直接返回
                        || board[i][j] != w.charAt(k)
                        // 如果在此次回溯中 当前字符已经使用过了，可以直接返回
                        || visited[i][j]
        ) {
            return false;
        }

        visited[i][j] = true;

        // 从当前位置的上下左右尝试
        boolean res = search(i + 1, j, k + 1)
                || search(i - 1, j, k + 1)
                || search(i, j + 1, k + 1)
                || search(i, j - 1, k + 1);
        // 为下一次回溯取消本次选择
        visited[i][j] = false;
        return res;
    }
}
