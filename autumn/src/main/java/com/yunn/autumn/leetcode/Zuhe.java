package com.yunn.autumn.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yunN
 * @date 2022/06/24
 */
public class Zuhe {


    List<List<Integer>> rs = new ArrayList<>();

    // backtrack
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> sub = new LinkedList<>();
        backtrack(n, k, sub);
        return rs;
    }

    void backtrack(int n, int k, LinkedList<Integer> sub){
        if (sub.size() == k) {
            rs.add(new LinkedList<>(sub));
            return;
        }
        if (n <= 0) return;
        // make
        sub.add(n);
        backtrack(n-1, k, sub);
        sub.removeLast();
    }
}
