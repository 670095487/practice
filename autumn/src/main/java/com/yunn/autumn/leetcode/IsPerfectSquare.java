package com.yunn.autumn.leetcode;

import org.junit.Test;

/**
 * @author yunN
 * @date 2022/05/10
 */
public class IsPerfectSquare {

    public boolean isPerfectSquare(int num) {
        // 最小除数就是1-9
        // 也就是说这个数除一个数，最后得到的商是这个除数
        if (num == 1) return true;
        int[] divides = {2, 3, 4, 5, 6, 7, 8, 9};
        int i = 0;
        int rs = 0;
        while (i < divides.length) {
            if (num % divides[i] != 0) {
                ++i;
                continue;
            }
            rs = num / divides[i];
            while (true) {
                if (rs != 1 && rs < divides[i]) {
                    i++;
                    break;
                } else if (rs == 1) {
                    return true;
                }
            }
            i++;
        }
        return false;
    }

    @Test
    public void test() {
        System.out.println(isPerfectSquare(76));
    }
}
