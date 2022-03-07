package com.yunn.autumn.leetcode;

/**
 * @author yunN
 * @date 2022/03/04.
 */
public class SortedArrayToBST {

    /*
        给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
        高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    * */
    public TreeNode sortedArrayToBST(int[] nums) {

        return build(nums, 0, nums.length - 1);
    }

    /**
     * 基本思路
     * 二叉树的构建问题很简单，说白了就是：构造根节点，然后构建左右子树。
     * 一个有序数组对于 BST 来说就是中序遍历结果，根节点在数组中心，数组左侧是左子树元素，右侧是右子树元素。
     */
    TreeNode build(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        // root
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        // left
        root.left = build(nums, left, mid - 1);
        // right
        root.right = build(nums, mid + 1, right);
        return root;
    }
}
