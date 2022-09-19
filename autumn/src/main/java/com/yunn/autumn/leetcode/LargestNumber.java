package com.yunn.autumn.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author yunN
 * @date 2022/09/18
 */
public class LargestNumber {

    int[] sortArrWithRules(int[] nums){
        int len = nums.length;
        String[] strArray = new String[len];
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                String s1 = String.valueOf(nums[i]);
                String s2 = String.valueOf(nums[j]);
                for (int x = 0; x < s1.length() || x < s2.length(); x++) {
                    int a = 0, b = 0;
                    if (x < s1.length()) {
                        a = s1.charAt(x);
                    }
                    if (x < s2.length()) {
                        b = s2.charAt(x);
                    }
                    if (b >= a) {
                        int tmp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = tmp;
                        break;
                    }
                }
            }
        }
        return nums;
    }

    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) ss[i] = "" + nums[i];
        Arrays.sort(ss, (a, b) -> {
            String sa = a + b, sb = b + a ;
            return sb.compareTo(sa);
        });

        StringBuilder sb = new StringBuilder();
        for (String s : ss) sb.append(s);
        // int len = sb.length();
        // int k = 0;
        // while (k < len - 1 && sb.charAt(k) == '0') k++;
        // return sb.substring(k);
        return sb.toString().replaceFirst("^0*", "");
    }

    @Test
    public void test() {
        int[] t1 = new int[]{3, 30, 34, 5, 9};
        System.out.println(largestNumber(t1));
    }
}
