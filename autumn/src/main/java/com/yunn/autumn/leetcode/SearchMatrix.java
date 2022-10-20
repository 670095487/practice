package com.yunn.autumn.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yunN
 * @date 2022/06/22
 */
public class SearchMatrix {


    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if (target > matrix[i][n - 1] || target < matrix[i][0]) {
                continue;
            }
            int left = 0, right = n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (target > matrix[i][mid]) {
                    left = mid + 1;
                } else if (target < matrix[i][mid]) {
                    right = mid - 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    public void test() {
        int[][] t = new int[][]{
                // [[1,3,5,7],[10,11,16,20],[23,30,34,60]]

                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        System.out.println(searchMatrix(t, 13));
    }


    @Test
    public void test1() {
        List<Integer> statistics = new ArrayList<>();
        Map<Integer, Long> nameMap = statistics.stream().collect(Collectors.groupingBy(p -> p, Collectors.counting()));
        Integer maxKey = -1;
        long max = -1;
        for (Map.Entry<Integer, Long> en : nameMap.entrySet()) {
            if (en.getValue() > max) {
                maxKey = en.getKey();
                max = en.getValue();
            }
        }
    }

    @Test
    public void t1() {
        System.out.println(String.format("http://%s:%s", "127.0.0.1", "9090"));
    }
}
