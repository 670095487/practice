package com.yunn.interview.剑指Offer;

import org.junit.Test;

/**
 * @author yunN
 * @date 2022/12/10
 */
public class _04 {

    // 自左向右：递增
    // 自上而下：递增
    // 二分
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix.length == 1 && matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if (matrix[i][n - 1] <= target) {
                if (matrix[i][n - 1] == target) return true;
            } else if (matrix[i][0] >= target) {
                if (matrix[i][0] == target) return true;
            } else {
                int left = 0, right = n - 1;
                while (left <= right) {
                    int mid = left + right + 1 >> 1;
                    if (matrix[i][mid] > target) {
                        right = mid - 1;
                    } else if (matrix[i][mid] < target) {
                        left = mid + 1;
                    } else {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    boolean findWithBinarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

    @Test
    public void test() {
        // System.out.println(findWithBinarySearch(new int[]{1}, 1));
        int[][] _2DArry = {{5}, {6}};
        System.out.println(findNumberIn2DArray(_2DArry,6));
    }
}
