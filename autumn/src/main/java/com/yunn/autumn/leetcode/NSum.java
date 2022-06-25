package com.yunn.autumn.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yunN
 * @date 2022/05/25
 */
public class NSum {


    public List<List<Integer>> nSum(int[] nums, int target, int n, int start) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        if (n < 2 || nums.length < n) return res;
        if (n == 2) {
            int low = start, high = nums.length - 1;
            while (low < high) {
                int sum = nums[low] + nums[high];
                int left = nums[low], right = nums[high];
                if (sum < target) {
                    while (low < high && nums[low] == left) {
                        low++;
                    }
                } else if (sum > target) {
                    while (low < high && nums[high] == right) {
                        high--;
                    }
                } else {
                    List<Integer> sub = new ArrayList<>();
                    sub.add(left);
                    sub.add(right);
                    res.add(sub);
                    while (low < high && nums[low] == left) {
                        low++;
                    }
                    while (low < high && nums[high] == right) {
                        high--;
                    }
                }
            }
        } else {
            for (int i = start; i < nums.length; i++) {
                List<List<Integer>> sub = nSum(nums, target - nums[i], n - 1, i + 1);
                for (List<Integer> s : sub) {
                    s.add(nums[i]);
                    res.add(s);
                }
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1,2,3,4,5,6,1};
        System.out.println(nSum(nums, 6, 3, 0));
    }
}
