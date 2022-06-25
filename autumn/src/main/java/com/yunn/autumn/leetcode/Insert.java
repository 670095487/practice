package com.yunn.autumn.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author yunN
 * @date 2022/06/13
 */
public class Insert {


    public int[][] insert(int[][] intervals, int[] newInterval) {
        return null;
    }

    @Test
    public void test() {
        int[][] ints = new int[][]{new int[]{1, 3}, new int[]{6, 9}};
        int[] newI = new int[]{2, 5};
        System.out.println(Arrays.deepToString(insert(ints, newI)));
    }

    @Test
    public void mutiplyArray() {
        int[][] arr = new int[][]{
                {2, 3, 3},
                {1, 2},
                {3, 4, 5, 6, 7}
        };
        int[] insert = new int[]{1, 2};
        int cow = arr.length;
        // for (int i = 0; i < cow; i++) {
        //     for (int j = 0; j < arr[i].length; j++) {
        //         System.out.println(arr[i][j]);
        //     }
        // }

        int[][] insertion = new int[cow + 1][];
        for (int i = 0; i < arr.length; i++) {
            insertion[i] = arr[i];
        }
        insertion[insertion.length - 1] = insert;
        System.out.println(Arrays.deepToString(insertion));
    }
}
