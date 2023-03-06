package com.yunn.interview.interviewquestion.d;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yunN
 * @date 2023/02/23.
 */
public class fourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if (len < 4) return ans;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 当前数组值大于0且当前值已经大于targrt，说明从这个数开始往后的4数之和不可能再等于target(数组已经排好序了)
            if (nums[i] > 0 && nums[i] > target) break;
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 第二位数字
            for (int j = i + 1; j < nums.length; j++) {
                // 去重
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                // if (nums[j] > 0 && nums[j] > target) break;
                int L = j + 1, R = len - 1;
                while (L < R) {
                    long sum = nums[i] + nums[j] + nums[L] + nums[R];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[L], nums[R]));
                        while (L < R && nums[L] == nums[L + 1]) L++;
                        while (L < R && nums[R] == nums[R - 1]) R--;
                        L++;
                        R--;
                    } else if (sum > target) {
                        R--;
                    } else {
                        L++;
                    }
                }
            }
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(fourSum(new int[]{2, 2, 2, 2}, 8));
    }
}
