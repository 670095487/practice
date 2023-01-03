package com.yunn.interview.剑指Offer;

/**
 * @date 2023/01/02
 */
public class _29 {

    /**
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     */
    public int[] spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] ans = new int[m * n];
        int left = 0, right = n - 1, top = 0, bottom = m - 1, cur = 0;
        while (true) {
            // 从左到右
            for (int i = left; i <= right; i++) {
                ans[cur++] = matrix[top][i];
            }
            if (++top > bottom) break;
            // 从上到下
            for (int i = top; i <= bottom; i++) {
                ans[cur++] = matrix[i][right];
                // 每完成一列，右边界减去1，直到左边界已经大于等于右边界
            }
            if (left > --right) break;
            // 从右到左
            for (int i = right; i >= left; i--) {
                // 行值不变，列是循环的变值
                ans[cur++] = matrix[bottom][i];
            }
            if (top > --bottom) break;
            // 从下到上
            for (int i = bottom; i >= top; i--) {
                // 列值不变，行是循环的变值
                ans[cur++] = matrix[i][left];
            }
            if (++left > right) break;
        }
        return ans;
    }
}
