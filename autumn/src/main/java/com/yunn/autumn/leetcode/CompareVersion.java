package com.yunn.autumn.leetcode;

import org.junit.Test;

/**
 * @author yunN
 * @date 2022/09/14
 */
public class CompareVersion {

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        StringBuilder s1 = handleLeads0(v1);
        System.out.println(s1);
        StringBuilder s2 = handleLeads0(v2);
        System.out.println(s2);
        int maxL = Math.max(s1.length(), s2.length());
        if (s1.length() < maxL) {
            for (int i = 0; i < maxL - s1.length(); i++) {
                s1.append("0");
            }
        }
        if (s2.length() < maxL) {
            for (int i = 0; i < maxL - s2.length(); i++) {
                s2.append("0");
            }
        }
        int i1 = Integer.parseInt(s1.toString());
        int i2 = Integer.parseInt(s2.toString());
        return Integer.compare(i1 - i2, 0);
    }

    StringBuilder handleLeads0(String[] target) {
        StringBuilder ans = new StringBuilder();
        for (String s : target) {
            String after = s.replaceFirst("^0+(?!$)", "");
            ans.append(after);
        }
        return ans;
    }

    public int compareVersion1(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < v1.length || i < v2.length; ++i) {
            int x = 0, y = 0;
            if (i < v1.length) {
                x = Integer.parseInt(v1[i]);
            }
            if (i < v2.length) {
                y = Integer.parseInt(v2[i]);
            }
            if (x > y) {
                return 1;
            }
            if (x < y) {
                return -1;
            }
        }
        return 0;
    }

    @Test
    public void test() {
        System.out.println(compareVersion1("1.1", "1.10"));
    }

    @Test
    public void test1() {
        String s = "001";
        String after = s.replaceFirst("^0+(?!$)", "");
        System.out.println(after);
    }
}
