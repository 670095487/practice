package com.yunn.autumn.leetcode;

import org.junit.Test;

/**
 * @author yunN
 * @date 2022/07/05
 */
public class CheckRecord {

    public boolean checkRecord(String s) {
        int absent = 0, lateTime = 0, preLate = -2;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'A') {
                absent++;
            } else if (arr[i] == 'L') {
                if (lateTime >= 3) return false;
                if (preLate != -2 && i - 1 == preLate) {
                    preLate = i;
                    lateTime++;
                } else {
                    preLate = i;
                    lateTime = 1;
                }
            }
        }

        return absent <= 2 && lateTime < 3;
    }

    @Test
    public void test() {
        checkRecord("LLLALL");
    }
}
