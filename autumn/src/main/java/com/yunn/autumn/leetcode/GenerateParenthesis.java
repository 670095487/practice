package com.yunn.autumn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yunN
 * @date 2022/05/28
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> rs = new ArrayList<>();
        if (n == 0) return rs;
        StringBuilder track = new StringBuilder();
        backtrack(n, n, track, rs);
        return rs;
    }

    void backtrack(int left, int right, StringBuilder track, List<String> rs) {
        // 括号是成对出现的,且是先左后右
        if (right < left) return;
        if (right < 0 || left < 0) return;
        // 括号均匹配完
        if (left == 0 && right == 0) {
            rs.add(track.toString());
            return;
        }

        track.append("(");
        backtrack(left - 1, right, track, rs);
        track.deleteCharAt(track.length() - 1);

        track.append(")");
        backtrack(left, right - 1, track, rs);
        track.deleteCharAt(track.length() - 1);
    }
}
