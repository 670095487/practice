package com.yunn.autumn.leetcode;

/**
 * @author yunN
 * @date 2022/06/21
 */
public class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] rs = new int[nums1.length];
        int l1 = nums1.length;
        int l2 = nums2.length;
        for (int i = 0; i < l1; i++) {
            int j = indexOfNums2(nums1[i], nums2);
            for (int j1 = j; j1 < l2; j1++) {
                if (nums2[j1] > nums1[i]){
                    rs[i] = nums2[j1];
                    break;
                }

                if (rs[i] == 0) rs[i] = -1;
            }

        }
        return rs;
    }

    private int indexOfNums2(int i, int[] nums2) {
        for (int i1 = 0; i1 < nums2.length; i1++) {
            if (i == nums2[i1]) return i1;
        }
        return -1;
    }
}
