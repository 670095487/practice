package com.yunn.interview.interviewquestion;

/**
 * @date 2022/12/31
 */
public class _23 {

    // 后序遍历：左右根
    // 因此，数组的最后一个元素是二叉搜索树的根，从左往右遍历，第一个比根大的元素就是右子树的开端
    // 从右子树的开端继续往后遍历，找到第一个不大于根的元素（如果这颗树是一颗二叉搜索树，那么此时的索引就是根所在的位置）
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    boolean recur(int[] postArray, int begin, int end) {
        if (begin >= end) return true;
        int left = begin;
        while (postArray[left] < postArray[end]) left++;
        int right = left;
        while (postArray[right] > postArray[end]) right++;
        return right == end && recur(postArray, begin, left - 1) && recur(postArray, left, right - 1);
    }
}
