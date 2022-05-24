package com.yunn.autumn.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yunN
 * @date 2022/05/19
 */
public class LicenseKeyFormatting {

    public String licenseKeyFormatting(String s, int k) {
        StringBuilder rs = new StringBuilder();
        for (int i = s.length() - 1; i > 0; i--) {
            if (s.charAt(i) != '-') {
                rs.append(rs);
            }
            if (rs.length() == k) {
                rs.append("-");
            }
        }

        if (rs.length() > 0 && rs.charAt(rs.length() - 1) == '-') {
            rs.deleteCharAt(rs.length() - 1);
        }
        return rs.reverse().toString().toUpperCase();
    }


    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        List<Integer> rs = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                max += 1;
                if (i == nums.length - 1) {
                    rs.add(max);
                }
            } else {
                rs.add(max);
                max = 0;
            }
        }
        return rs.stream().mapToInt(v -> v).max().getAsInt();
    }

    @Test
    public void test() {
    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int rs = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            if (i - 1 >= 0 && rs == timeSeries[i]) {
                rs += 1;
            } else if (i - 1 >= 0 && rs > timeSeries[i]) {

            } else {
                rs += 2;
            }
        }
        return rs;
    }

}

