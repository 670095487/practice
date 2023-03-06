package com.yunn.interview.interviewquestion.d;

/**
 * @author yunN
 * @date 2023/02/12.
 */
public class SortedSquares {

    public int[] sortedSquares_2traverse(int[] nums) {
        int n = nums.length;
        // 找到正负分界点 (不是一个负数的index，所以不能在找到第一个以后直接break)
        int negative = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                negative = i;
            } else {
                break;
            }
        }

        int[] ans = new int[n];
        // 将原数组分成2段（负数-0-正数）
        // 已知原数组是非递减顺序排序的数组，所以负数平方以后应该降序排列的，正数仍旧保持升序排列
        int index = 0, i = negative, j = negative + 1;
        while (i >= 0 || j < n) {
            /* 说明原数组中没有负数，平方以后可以仍旧按照之前的顺序排列 */
            if (i < 0) {
                // 记录当前位置平方后的值
                ans[index] = nums[j] * nums[j];
                // 正数索引+1
                ++j;
                // 说明正数部分已经平方计算完成，剩下的只剩负数了，直接将负数的平方放置ans数组中即可
            } else if (j == n) {
                ans[index] = nums[i] * nums[i];
                --i;
                // 一般情况：比较正负数平方值的大小
            } else if (nums[i] * nums[i] < nums[j] * nums[j]) {
                ans[index] = nums[i] * nums[i];
                --i;
            } else {
                ans[index] = nums[j] * nums[j];
                ++j;
            }
            ++index;
        }
        return ans;
    }

    // 双指针法
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[nums.length];
        int low = 0, high = nums.length - 1;
        int index = n - 1;
        while (low != high) {
            if (nums[low] * nums[low] < nums[high] * nums[high]) {
                res[index--] = nums[high] * nums[high];
                high--;
            } else {
                res[index--] = nums[low] * nums[low];
                low++;
            }
        }
        return res;
    }

}
