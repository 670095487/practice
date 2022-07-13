package com.yunn.autumn.leetcode.dfsandbfs;

import java.util.List;

/**
 * @author yunN
 * @date 2022/07/10
 */
class MaxDepth {

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        List<Node> childDepth = root.children;
        int maxDepth = 0;
        for (Node c : childDepth) {
            int n = maxDepth(c);
            maxDepth = Math.max(maxDepth, n);
        }
        return maxDepth + 1;
    }
}
