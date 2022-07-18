package com.yunn.autumn.leetcode;

import org.junit.Test;

/**
 * @author yunN
 * @date 2022/07/18
 */
public class MatrixReshape {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }

        int[][] ans = new int[r][c];
        for (int x = 0; x < m * n; ++x) {
            ans[x / c][x % c] = nums[x / n][x % n];
        }
        return ans;
    }

    public int[][] matrixReshape2(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }

        int[][] ans = new int[r][c];
        int x = 0, y = 0;
        for (int[] num : nums) {
            for (int j = 0; j < n; j++) {
                ans[x][y] = num[j];
                y++;
                if (y == c) {
                    y = 0;
                    x++;
                }
            }
        }
        return ans;
    }

    @Test
    public void test() {

        int[][] c = new int[][]{
                {1, 2},
                {3, 4}
        };
        matrixReshape(c, 1, 4);
    }

}
