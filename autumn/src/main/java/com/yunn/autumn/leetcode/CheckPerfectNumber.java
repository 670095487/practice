package com.yunn.autumn.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yunN
 * @date 2022/06/26
 */
public class CheckPerfectNumber {

    public boolean checkPerfectNumber(int num) {
        List<Integer> positive = new ArrayList<>();
        int i = 1;
        while(i < num) {
            if (num % i == 0) {
                positive.add(i);
            }
            i++;
        }
        int sum = 0;
        for (int j = 0; j <positive.size(); j++) {
            sum += positive.get(j);
        }

        return num == sum;
    }

    @Test
    public void test() {
        checkPerfectNumber(28);
    }
}
