package com.yunn.autumn.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author yunN
 * @date 2022/06/26
 */
public class Exist {

    public boolean exist(char[][] board, String word) {
        Map<Character, Integer> countsMap = new HashMap<>();
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Integer pre = countsMap.get(board[i][j]);
                if (null == pre) {
                    countsMap.put(board[i][j], 1);
                } else {
                    countsMap.put(board[i][j], ++pre);
                }
            }
        }
        for (int i = 0; i < word.length(); i++) {
            Integer rs = countsMap.get(word.charAt(i));
            if (rs == null) {
                return false;
            } else {
                rs--;
                if (rs < 0) {
                    return false;
                } else {
                    countsMap.put(word.charAt(i), rs);
                }
            }
        }
        return countsMap.values().stream().noneMatch(a -> a < 0);
    }

    @Test
    public void test() {
        char[][] s = new char[][]{
                {'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        System.out.println(exist(s, word));
    }
}
