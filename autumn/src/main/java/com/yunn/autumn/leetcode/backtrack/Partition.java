package com.yunn.autumn.leetcode.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yunN
 * @date 2022/08/14
 */
public class Partition {

    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(s, 0, new LinkedList<String>());
        return ans;

    }

    void backtrack(String s, int startIndex, LinkedList<String> path) {
        if (startIndex >= s.length()) {
            ans.add(new LinkedList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isPalinDromes(s, startIndex, i + 1)) {
                path.add(s.substring(startIndex, i + 1));
            }
            backtrack(s, i + 1, path);
            path.removeLast();
        }
    }

    boolean isPalinDromes(String s, int start, int end) {
        String word = s.substring(start, end);
        int i = 0, j = word.length() - 1;
        while (i <= j) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    @Test
    public void test() {
        String s = "aab";
        System.out.println(s.substring(0, 2));
    }
}
