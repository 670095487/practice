package com.yunn.autumn.leetcode;

import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yunN
 * @date 2022/06/06
 */
public class RevertString {

    public void revertString(String source) {
        int i = 0, j = source.length() - 1;
        while (i < j) {
            // source.charAt(i) = source.charAt(j);
        }
    }

    @Test
    public void test() {
        char[] ch = { 'G', 'e', 'e', 'k', 's', 'f', 'o',
                'r', 'G', 'e', 'e', 'k', 's' };

        // Converting character array into string
        // using joining() method of Collectors class
        String chString
                = Stream.of(ch)
                .map(String::new)
                .collect(Collectors.joining());

        // Printing concatenated string
        System.out.println(chString);
    }
}
