package com.yunn.autumn.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yunN
 * @date 2022/01/20
 */
public class Merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

    }

    // 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi]
    // 请你合并所有重叠的区间
    public int[][] mergeMy(int[][] intervals) {
        LinkedList<int[]> res = new LinkedList<>();
        // 1.先按左边界排序 左边界就是a[0]
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        // 2.维护一个start,end 代表上一个区间范围
        int preStart = intervals[0][0];
        int preEnd = intervals[0][1];
        // 3. 三种情况
        //  3.1 curStart > preStart, curEnd < preEnd --> add(preStart, preEnd)
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][1] < preEnd && intervals[i][0] > preStart) {
                res.add(intervals[0]);
            //  3.2 curStart > preStart , curEnd > preEnd --> add(preStart, curEnd)
            } else if (intervals[i][1] > preEnd && intervals[i][0] > preStart) {
                res.add(new int[]{preStart, intervals[i][1]});
                preEnd = intervals[i][1];
            }else {

            }
        }
        return null;
    }

    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> res = new LinkedList<>();
        // 按区间的 start 升序排列
        Arrays.sort(intervals);

        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            // res 中最后一个元素的引用
            int[] last = res.getLast();
            if (curr[0] <= last[1]) {
                last[1] = Math.max(last[1], curr[1]);
            } else {
                // 处理下一个待合并区间
                res.add(curr);
            }
        }
        return res.toArray(new int[0][0]);
    }
}
