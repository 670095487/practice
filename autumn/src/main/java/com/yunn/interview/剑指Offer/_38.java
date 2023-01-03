package com.yunn.interview.剑指Offer;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @date 2023/01/03
 */
public class _38 {

    Set<String> res = new HashSet<>();

    public String[] permutation(String s) {
        boolean[] visited = new boolean[s.length()];
        StringBuilder sb = new StringBuilder();
        char[] ch = s.toCharArray();
        backtrack(ch, sb, visited);
        return res.toArray(new String[0]);
    }

    // s="abc"
    // a->c->b a->b->c b->a->c
    void backtrack(char[] chars, StringBuilder sb, boolean[] visited) {
        if (chars.length == sb.length()) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) continue;
            sb.append(chars[i]);
            visited[i] = true;
            backtrack(chars, sb, visited);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(permutation("abc")));
    }

}
