package com.yunn.autumn.leetcode.tree;

import com.yunn.autumn.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yunN
 * @date 2022/11/04
 */
public class LC235 {

    // 思路：分别查找pq在树中的完整路径，再找到相遇点的最大值，就是最近的公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path_p = getPath(root, p);
        List<TreeNode> path_q = getPath(root, q);
        TreeNode ans = null;
        for (int i = 0; i < path_p.size() && i < path_q.size(); i++) {
            if (path_p.get(i) == path_q.get(i)) {
                ans = path_p.get(i);
            }
        }
        return ans;
    }

    List<TreeNode> getPath(TreeNode node, TreeNode target) {
        List<TreeNode> path = new ArrayList<>();
        while (node != target) {
            path.add(node);
            if (node.val < target.val) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        path.add(node);
        return path;
    }
}
