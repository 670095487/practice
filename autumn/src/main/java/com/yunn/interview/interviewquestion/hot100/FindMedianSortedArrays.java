package com.yunn.interview.interviewquestion.hot100;

/**
 * @author yunN
 * @date 2023/01/05.
 */
public class FindMedianSortedArrays {

    /**
     *
        - 先合并2个数组
            - 中位数：
                - 1.奇数个：n/2 + 1
                - 2.偶数个：n/2 + n/2 + 1
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double ans = 0;




        return ans;

    }

    private int[] merge(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int p1 = 0, p2 = 0;
        int cur;
        int[] sorted = new int[m + n];
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n){
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1+p2-1] = cur;
        }
        return sorted;
    }
}
