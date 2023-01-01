package com.yunn.autumn.leetcode.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author yunN
 * @date 2022/11/21.
 */
public class quickSort {

    public int[] sortArray(int[] nums) {
        randomizedQuicksort(nums, 0, nums.length - 1);
        return nums;
    }

    public void randomizedQuicksort(int[] nums, int left, int right) {
        if (left < right) {
            int pos = randomizedPartition(nums, left, right);
            // 左半边
            randomizedQuicksort(nums, left, pos - 1);
            // 右半边
            randomizedQuicksort(nums, pos + 1, right);
        }
    }

    public int randomizedPartition(int[] nums, int left, int right) {
        int i = new Random().nextInt(right - left + 1) + left; // 随机选一个作为我们的主元
        swap(nums, right, i);
        return partition(nums, left, right);
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left - 1;
        for (int j = left; j <= right - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, right);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void test() {
        int[] arr = {5, 2, 3, 1};
        // sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
