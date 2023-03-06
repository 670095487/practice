package com.yunn.interview.interviewquestion.d;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yunN
 * @date 2023/02/21.
 */
public class HappyValue {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        // 利用hashSet来判断当前n曾经有没有出现过，出现过则跳过
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }

    /**
     * while循环对n取余数，一位一位的平方，然后求和
     */
    private int getNextNumber(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(getNextNumber(15));
    }

}
