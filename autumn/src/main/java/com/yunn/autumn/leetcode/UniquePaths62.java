package com.yunn.autumn.leetcode;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author yunN
 * @date 2022/06/16
 */
public class UniquePaths62 {

    int[][] memo;

    // (x , y - 1 ) + (x-1, y)
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        return dp(m - 1, n - 1);
    }

    int dp(int x, int y) {
        // base case
        if (x == 0 && y == 0) {
            return 1;
        }

        if (x < 0 || y < 0) {
            return 0;
        }

        if (memo[x][y] > 0) {
            return memo[x][y];
        }

        memo[x][y] = dp(x - 1, y) + dp(x, y - 1);
        return memo[x][y];
    }

    @Test
    public void test() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.stream().reduce(Integer::sum).orElse(0);
        list.clear();
    }


}
