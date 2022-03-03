package com.yunn.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author yunN
 * @date 2021/11/30
 */
public class Sort {


    public static void main(String[] args) {
        int[] readyToSort = {3, 1, 6, 4, 2, 9, 6, 5, 7};
        // selectionSort(readyToSort);
        // bubbleSort(readyToSort);
        insertionSort(readyToSort);
        Arrays.stream(readyToSort).forEach(System.out::println);

    }

    private static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    minIndex = j;
                    selectionSortSwap(i, minIndex, arr);
                }
            }
        }
    }

    private static void selectionSortSwap(int i, int minIndex, int[] arr) {
        int tmp = arr[minIndex];
        arr[minIndex] = arr[i];
        arr[i] = tmp;
    }

    private static void bubbleSort(int[] arr) {
        for (int e = arr.length - 1; e > 0; e--) {// 比较次数范围在0~e，每比较一次以后，下次需要比的元素里就减去1个
            for (int i = 0; i < e; i++) {// 这个循环针对的是外层数组e还有多少个元素，就比较多少次
                if (arr[i] > arr[i + 1]) {
                    selectionSortSwap(i, i + 1, arr);
                }
            }
        }
    }

    private static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {// 这个正好和bubbleSort的最外层反过来了
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j + 1] < arr[j]) {
                    selectionSortSwap(j, j + 1, arr);
                }
            }
        }
    }

    // 异或(XOR) 相同为0 不同为1
    // 1. 满足交换律，结合律；2. 0^N = N, N^N = 0
    @Test
    public void testXOR() {
        System.out.println(0 ^ 3);
        System.out.println(3 ^ 3);
    }
}

