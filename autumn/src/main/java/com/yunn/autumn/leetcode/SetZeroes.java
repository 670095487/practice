package com.yunn.autumn.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yunN
 * @date 2022/06/21
 */
public class SetZeroes {

    // 找到matrix[x][y] == 0
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<String> xy = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    xy.add(String.valueOf(i) + "-" + String.valueOf(j));
                }
            }
        }
        // 1. (x,y)->(x, 0……n-1)
        // 2. (x,y)->(0……m-1, y)
        if (!xy.isEmpty()) {
            for (int k = 0; k < xy.size(); k++) {
                int x = Integer.parseInt(xy.get(k).split("-")[0]);
                int y = Integer.parseInt(xy.get(k).split("-")[1]);
                for (int i = 0; i < n; i++) {
                    matrix[x][i] = 0;
                }
                for (int i = 0; i < m; i++) {
                    matrix[i][y] = 0;
                }
            }
        }
    }


    @Test
    public void test() {
        int[][] x = new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        setZeroes(x);
    }

    @Test
    public void test1() {
        char[] chars = new char[26];
        ArrayList<String> list = new ArrayList<>();
        list.add("1564");
        list.add("1562");
        list.add("1522");
    }
}
