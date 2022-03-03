package com.yunn.autumn.leetcode;

import java.util.Arrays;

/**
 * Sort
 *
 * @author yunN
 * @createTime 2021年03月25日 17:23
 * @description 排序类算法
 */
public class Sort {


    /**
     * 冒泡排序
     * 算法思路：从首元素开始比较，每次比较一轮，每次将最大的元素调整至队列尾
     *
     * @param arr /
     * @return /
     */
    private static int[] bubbleSort(int[] arr) {

        if (arr == null || arr.length == 0) return null;

        int loopDepth = arr.length;

        for (int i = 0; i < loopDepth; i++) {

            for (int j = 0; j < loopDepth - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 选择排序
     *
     * @param arr /
     */
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {//交换次数
            //先假设每次循环时，最小数的索引为i
            int minIndex = i;
            //每一个元素都和剩下的未排序的元素比较
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {//寻找最小数
                    minIndex = j;//将最小数的索引保存
                }
            }
            //经过一轮循环，就可以找出第一个最小值的索引，然后把最小值放到i的位置
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 5, 4};
        System.out.println(Arrays.toString(bubbleSort(arr)));
    }

}
