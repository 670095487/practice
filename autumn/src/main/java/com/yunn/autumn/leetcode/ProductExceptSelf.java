package com.yunn.autumn.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author yunN
 * @date 2022/10/17.
 *
 * 索引4处的乘积 = 1*2*3*5*6*7 = （1*2*3）*（5*6*7）
 */
public class ProductExceptSelf {

    // 左右乘积
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] l = new int[n];
        l[0] = 1;
        int[] r = new int[n];
        for (int i = 1; i < n; i++) {
            l[i] = nums[i - 1] * l[i - 1];
        }
        r[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            r[i] = nums[i + 1] * r[i + 1];
        }
        // 索引i处的乘积就等于i左右两边的乘积的乘积
        for (int i = 0; i < n; i++) {
            ans[i] = l[i] * r[i];
        }
        return ans;
    }

    @Test
    public void test() {
        int[] ints = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(ints)));
    }
}
