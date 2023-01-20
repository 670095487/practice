package com.yunn.interview.interviewquestion.hot100;

import com.yunn.autumn.leetcode.TreeNode;

import java.util.Arrays;

/**
 * @date 2023/01/19
 */
public class Rob3 {

    // https://www.bilibili.com/video/BV1H24y1Q7sY/?spm_id_from=333.337.search-card.all.click&vd_source=1d6d9041155f243202f17cbfa7fbc000
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int[] ints = postOrder(root);
        return Arrays.stream(ints).max().getAsInt();
    }

    // 0-偷，1-不偷
    int[] postOrder(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] leftVal = postOrder(root.left);
        int[] rightVal = postOrder(root.right);
        // 当前节点偷,则左右孩子不能偷
        int val_0 = root.val + leftVal[1] + rightVal[1];
        // 当前节点不偷，则左右孩子选最大值
        int val_1 = Arrays.stream(leftVal).max().getAsInt() + Arrays.stream(rightVal).max().getAsInt();
        return new int[]{val_0, val_1};
    }
}
