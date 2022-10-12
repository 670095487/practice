package com.yunn.autumn.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author yunN
 * @date 2022/10/10.
 */
public class CountPrimes {

    public int countPrimes(int n) {
        if (n == 0 || n == 1) return 0;
        int ans = 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime,true);
        // 遍历2-sqrt(n)范围内
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]){
                // 将所有非质数填充成false
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // 统计质数个数
        for (boolean b : isPrime) {
            if (b) ans++;
        }

        return ans-2;
    }

    @Test
    public void test() {
        System.out.println(countPrimes(10));
    }
}
