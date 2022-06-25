package com.yunn.autumn.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yunN
 * @date 2022/06/22
 */
public class FindWords {

    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        String rowIdx = "12210111011122000010020202";// q-第0行，a-第1行，z-第2行，依次类推
        for (String word : words) {
            boolean flag = true;
            char idx = rowIdx.charAt(((Character.toLowerCase(word.charAt(0)) - 'a')));
            for (int i = 1; i < word.length(); i++) {
                if (idx != rowIdx.charAt(((Character.toLowerCase(word.charAt(i)) - 'a')))) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                list.add(word);
            }
        }

        String[] rs = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            rs[i] = list.get(i);
        }
        return rs;
    }

    @Test
    public void test() {
        char x = 'z';
        System.out.println(x - 'a');
    }

}
