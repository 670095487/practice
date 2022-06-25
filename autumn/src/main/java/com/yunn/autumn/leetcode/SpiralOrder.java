package com.yunn.autumn.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yunN
 * @date 2022/06/08
 */
public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> rs = new ArrayList<>();
        int rows = matrix.length;// 二维数组的行数
        int columns = matrix[0].length;// 二维数组的列数
        int upper = 0;// 第一行，行数上边界
        int bottom = rows - 1;// 最后一行，行数下边界
        int left = 0;// 第0列，列数左边界
        int right = columns - 1;// 最后一列，列数右边界

        while (rs.size() < rows * columns) {
            // 在顶部从左向右遍历 ，upper代表的行数，从第0行开始
            if (upper <= bottom) {
                for (int j = left; j <= right; j++) {
                    rs.add(matrix[upper][j]);
                }
                // 最小行数下移
                upper++;
            }

            // 从上往下遍历，从每一行的尾部自上而下遍历
            if (left <= right) {
                for (int i = upper; i <= bottom; i++) {
                    rs.add(matrix[i][right]);
                }
                // 最大列数左移
                right--;
            }

            // 从右往左遍历
            if (upper <= bottom) {
                for (int j = right; j >= left; j--) {
                    rs.add(matrix[bottom][j]);
                }
                // 最大行数上移
                bottom--;
            }

            // 自下而上遍历
            if ((left <= right)) {
                for (int i = bottom; i >= upper; i--) {
                    rs.add(matrix[i][left]);
                }
                // 最小列数右移
                left++;
            }
        }
        return rs;
    }

    @Test
    public void test() {
        int[][] arr = new int[3][5];
        System.out.println(arr.length);// 行数
        System.out.println(arr[0].length);// 列数
    }
}
