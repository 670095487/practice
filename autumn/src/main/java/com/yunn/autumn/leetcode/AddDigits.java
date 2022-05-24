package com.yunn.autumn.leetcode;

import org.junit.Test;

/**
 * @author yunN
 * @date 2022/04/29
 */
public class AddDigits {

    public int addDigits(int num) {

        if (num == 0) {
            return 0;
        }

        if (num < 10) {
            return num;
        }

        int quotient = num / 10;// quotient:商数
        int remainder = num % 10;// remainder:余数
        int total = quotient + remainder;
        if (total > 9) {
            return addDigits(total);
        }
        return total;
    }

    @Test
    public void test() {
        System.out.println(addDigits(38));
    }
}
