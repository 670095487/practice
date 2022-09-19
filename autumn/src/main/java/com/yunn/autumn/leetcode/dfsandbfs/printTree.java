package com.yunn.autumn.leetcode.dfsandbfs;

import com.yunn.autumn.leetcode.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yunN
 * @date 2022/08/01
 * <p>
 * BFS + DFS
 */
public class printTree {

    String[][] ans = new String[][]{};

    // m = height + 1 , n = 2^(height + 1) - 1
    public List<List<String>> printTree1(TreeNode root) {

        if (root == null) return null;

        // 1. dfs --> height
        int height = dfs(root);
        // 2. 将结点入队，
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                TreeNode curNode = queue.poll();

                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }

                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }

        }
        return null;
    }

    private int dfs(TreeNode root) {
        return 0;
    }

    static class Params {
        Params(TreeNode n, int ii, int ll, int rr) {
            root = n;
            i = ii;
            l = ll;
            r = rr;
        }

        TreeNode root;
        int i, l, r;
    }

    public List<List<String>> printTreeOfficial(TreeNode root) {
        int height = getHeight(root);
        System.out.println(height);
        String[][] res = new String[height][(1 << height) - 1];
        for (String[] arr : res)
            Arrays.fill(arr, "");
        List<List<String>> ans = new ArrayList<>();
        fill(res, root, 0, 0, res[0].length);
        for (String[] arr : res)
            ans.add(Arrays.asList(arr));
        return ans;
    }

    public void fill(String[][] res, TreeNode root, int i, int l, int r) {
        Queue<Params> queue = new LinkedList();
        queue.add(new Params(root, 0, 0, res[0].length));
        while (!queue.isEmpty()) {
            Params p = queue.remove();
            res[p.i][(p.l + p.r) / 2] = "" + p.root.val;
            if (p.root.left != null)
                queue.add(new Params(p.root.left, p.i + 1, p.l, (p.l + p.r) / 2));
            if (p.root.right != null)
                queue.add(new Params(p.root.right, p.i + 1, (p.l + p.r + 1) / 2, p.r));
        }
    }

    public int getHeight(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int height = 0;
        while (!queue.isEmpty()) {
            height++;
            Queue<TreeNode> temp = new LinkedList();
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                if (node.left != null)
                    temp.add(node.left);
                if (node.right != null)
                    temp.add(node.right);
            }
            queue = temp;
        }
        return height;
    }

    public List<List<String>> printTree(TreeNode root) {
        int m = getDepth(root);
        int n = (int) (Math.pow(2, m) - 1);
        String[][] res = new String[m][n];
        for (String[] re : res) {
            Arrays.fill(re, "");
        }
        dfs(root, 0, 0, n, res);
        return Arrays.stream(res).map(Arrays::asList).collect(Collectors.toList());
    }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return Math.max(left, right) + 1;
    }

    private void dfs(TreeNode root, int depth, int l, int r, String[][] res) {
        if (root == null) return;
        int mid = (r - l) / 2 + l;// 6-0/2 = 3 + 0 = 3
        res[depth][mid] = "" + root.val;
        dfs(root.left, depth + 1, l, mid, res);
        dfs(root.right, depth + 1, mid + 1, r, res);
    }
}
