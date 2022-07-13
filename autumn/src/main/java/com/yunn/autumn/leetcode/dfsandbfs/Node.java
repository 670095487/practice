package com.yunn.autumn.leetcode.dfsandbfs;

import java.util.List;

/**
 * @author yunN
 * @date 2022/07/10
 */
public class Node {

        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
}
