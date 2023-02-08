package com.yunn.interview.interviewquestion.hot100;

/**
 * @author yunN
 * @date 2023/02/08.
 */
public class CountBits {

    /*
     计算0-n内所有数字转换位二进制后1出现的次数
        x&(x-1) ==> x的二进制位最后一位会变成0
        因此计算x的二进制上1的数目就是看&在操作多少次后，x会变成0
     */
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for (int i = 1; i <= n; i++) {
            ans[i] = countBitss(i);
        }
        return ans;
    }

    private int countBitss(int x) {
        int count = 0;
        while (x > 0) {
            x = x & (x - 1);
            count++;
        }
        return count;
    }
}
