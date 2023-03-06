package com.yunn.interview.interviewquestion.d;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yunN
 * @date 2023/03/01.
 */
public class combine3 {

    List<List<Integer>> ans = new ArrayList<>();
    int k, target;

    // 只使用1-9，去重，k个数 和为target
    public List<List<Integer>> combinationSum3(int k, int target) {
        this.k = k;
        this.target = target;
        backtrack(1, 0, new LinkedList<>());
        return ans;
    }

    void backtrack(int start, int currentSum, LinkedList<Integer> sub) {

        if (sub.size() == k) {
            if (currentSum == target) {
                ans.add(new LinkedList<>(sub));
            }
        }
        for (int i = start; i <= 9; i++) {
            sub.addLast(i);
            currentSum += i;
            backtrack(i + 1, currentSum, sub);
            currentSum -= i;
            sub.removeLast();
        }
    }
}
