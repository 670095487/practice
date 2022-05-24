package com.yunn.autumn.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yunN
 * @date 2022/04/18
 */
public class IsHappy {

    public int getNextN(int n) {
        int total = 0;
        while (n > 0) {
            int e = n % 10;
            n = n / 10;
            total = e * e + total;
        }
        return total;
    }

    public boolean isHappy(int n) {
        Set<Integer> happySet = new HashSet<>();
        while (n != 1 && !happySet.contains(n)) {
            happySet.add(n);
            n = getNextN(n);
        }
        return n == 1;
    }

    @Test
    public void test() {
        String s = "";
    }
}
