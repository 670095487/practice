package com.yunn.interview.剑指Offer;

import org.junit.Test;

import java.util.Arrays;

/**
 * @date 2022/12/28
 */
public class _40 {

    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1);
        return Arrays.copyOf(arr, k);
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int i = left, j = right;
        while (i < j) {
            // 从右找第一个小于基准数的数
            while (i < j && arr[j] >= arr[left]) j--;
            // 从左找第一个大于基准数的数
            while (i < j && arr[i] <= arr[left]) i++;
            // 找到待交换的点后交换
            swap(arr, i, j);
        }
        // 交换左基准数
        swap(arr, i, left);
        // 左半边递归quickSort
        quickSort(arr, left, i - 1);
        // 右半边
        quickSort(arr, i + 1, right);
    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void test() {
        int[] arr = {5, 2, 3, 1};
        quickSort(arr,0,3);
        System.out.println(Arrays.toString(arr));
    }
}
