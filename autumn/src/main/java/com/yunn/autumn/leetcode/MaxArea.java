package com.yunn.autumn.leetcode;

/**
 * @author yunN
 * @date 2022/05/10
 */
public class MaxArea {

    public int maxArea(int[] height) {
        // 长 * 宽
        // 长：X轴长度，也就是数组中索引差值，
        // 宽：数组中2个元素较小值
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while(left < right) {
            max = Math.max(max, getArea(height, left, right));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    // left >= right
    int getArea(int[] arr, int left, int right) {
        if(left == right) return 0;
        int wide = Math.min(arr[left], arr[right]);
        return (right - left) * wide;
    }
}
