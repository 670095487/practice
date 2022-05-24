package com.yunn.autumn.leetcode;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author yunN
 * @date 2022/04/25
 */
public class HasGroupsSizeX {
    public boolean hasGroupsSizeX(int[] deck) {
        int[] count = new int[10000];
        for (int c : deck) {
            count[c]++;
        }

        int g = -1;
        for (int i = 0; i < 10000; ++i) {
            if (count[i] > 0) {
                if (g == -1) {
                    g = count[i];
                } else {
                    g = gcd(g, count[i]);
                }
            }
        }
        return g >= 2;
    }

    public int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }

    int[] get(int[] deck) {
        int[] count = new int[6];
        for (int c : deck) {
            count[c]++;
        }
        return count;
    }

    @Test
    public void test1() {
        System.out.println(Arrays.toString(get(new int[]{1, 1, 2, 2})));
    }

    @Test
    public void test() {
        String s = "null";
        String S1 = null;
        System.out.println(s + S1);
    }
}
