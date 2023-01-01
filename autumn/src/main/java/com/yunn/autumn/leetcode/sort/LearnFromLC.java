package com.yunn.autumn.leetcode.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @date 2022/12/28
 */
public class LearnFromLC {

    private void quickSort(int[] arr, int l, int r) {
        // 子数组长度为 1 时终止递归
        if (l >= r) return;
        // 哨兵划分操作（以 arr[l] 作为基准数）
        int i = l, j = r;
        while (i < j) {
            while (i < j && arr[j] >= arr[l]) j--;
            while (i < j && arr[i] <= arr[l]) i++;
            swap(arr, i, j);
        }
        swap(arr, i, l);
        // 递归左（右）子数组执行哨兵划分
        quickSort(arr, l, j - 1);
        quickSort(arr, j + 1, r);
    }
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    @Test
    public void test() {
        int[] arr = new int[]{5, 2, 3, 1};
        quickSort(arr, 0, 3);
        System.out.println(Arrays.toString(arr));
    }
}
