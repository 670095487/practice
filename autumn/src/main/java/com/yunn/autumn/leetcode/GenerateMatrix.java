package com.yunn.autumn.leetcode;

/**
 * @author yunN
 * @date 2022/06/14
 */
public class GenerateMatrix {

    // 待填入数字
    int num = 1;

    public int[][] generateMatrix(int n) {
        int[][] rs = new int[n][n];
        int upper_bound = 0;
        int lower_bound = n - 1;
        int left_bound = 0;
        int right_bound = n - 1;

        while (num < n * n) {
            if (upper_bound <= lower_bound) {
                for (int i = left_bound; i <= right_bound; i++) {
                    rs[upper_bound][i] = num++;
                }
                upper_bound++;
            }

            if (left_bound <= right_bound) {
                for (int i = upper_bound; i <= lower_bound; i++) {
                    rs[i][right_bound] = num++;
                }
                right_bound--;
            }

            if (upper_bound <= lower_bound) {
                for (int i = right_bound; i >= left_bound; i--) {
                    rs[lower_bound][i] = num++;
                }
                lower_bound--;
            }

            if (left_bound <= right_bound) {
                for (int i = lower_bound; i >= upper_bound; i--) {
                    rs[i][left_bound] = num++;
                }
                left_bound++;
            }
        }
        return rs;
    }

    int[][] generateMatrix1(int n) {
        int[][] matrix = new int[n][n];
        int upper_bound = 0, lower_bound = n - 1;
        int left_bound = 0, right_bound = n - 1;
        // 需要填入矩阵的数字
        int num = 1;

        while (num <= n * n) {
            if (upper_bound <= lower_bound) {
                // 在顶部从左向右遍历
                for (int j = left_bound; j <= right_bound; j++) {
                    matrix[upper_bound][j] = num++;
                }
                // 上边界下移
                upper_bound++;
            }

            if (left_bound <= right_bound) {
                // 在右侧从上向下遍历
                for (int i = upper_bound; i <= lower_bound; i++) {
                    matrix[i][right_bound] = num++;
                }
                // 右边界左移
                right_bound--;
            }

            if (upper_bound <= lower_bound) {
                // 在底部从右向左遍历
                for (int j = right_bound; j >= left_bound; j--) {
                    matrix[lower_bound][j] = num++;
                }
                // 下边界上移
                lower_bound--;
            }

            if (left_bound <= right_bound) {
                // 在左侧从下向上遍历
                for (int i = lower_bound; i >= upper_bound; i--) {
                    matrix[i][left_bound] = num++;
                }
                // 左边界右移
                left_bound++;
            }
        }
        return matrix;
    }

}
