package com.yunn.interview.interviewquestion.d;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yunN
 * @date 2023/03/01.
 */
public class Combine {

    List<List<Integer>> ans = new ArrayList<>();
    int ks;

    public List<List<Integer>> combine(int n, int k) {
        this.ks = k;
        backtrack(n, 1, new LinkedList<>());
        return ans;
    }

    void backtrack(int n, int start, LinkedList<Integer> sub) {
        if (sub.size() == ks) {
            ans.add(new LinkedList<>(sub));
            return;
        }
        for (int i = start; i <= n; i++) {
            sub.addLast(i);
            backtrack(n, i + 1, sub);
            sub.removeLast();
        }
    }

    @Test
    public void test() {
        System.out.println(combine(4, 2));
    }

}
