package com.yunn.autumn.leetcode;

import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * MaxSubArray
 * <p>
 * 找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        int pre = 0;
        int maxNum = nums[0];

        for (int num : nums) {
            pre = Math.max(pre + num, num);
            maxNum = Math.max(pre, maxNum);
        }
        return maxNum;
    }

    @Test
    public void testMaxNSubArray() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    @Test
    public void test1() {
        String s = "PMT" + LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd")) + "1";
        System.out.println(s);
    }
}
