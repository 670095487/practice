package com.yunn.autumn.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yunN
 * @date 2022/05/20
 */
public class ThreeSum {

    List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
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
                sub.add(low);
                sub.add(high);
                res.add(sub);
                while (low < high && nums[low] == left) {
                    low++;
                }
                while (low < high && nums[high] == right) {
                    high--;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum(int[] nums) {// 总时间复杂度：O(n^2)
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length <= 2) return ans;

        Arrays.sort(nums); // O(nlogn)

        for (int i = 0; i < nums.length - 2; i++) { // O(n^2)
            if (nums[i] > 0) break; // 第一个数大于 0，后面的数都比它大，肯定不成立了
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去掉重复情况
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    // 现在要增加 left，减小 right，但是不能重复，比如: [-2, -1, -1, -1, 3, 3, 3], i = 0,
                    // left = 1, right = 6, [-2, -1, 3] 的答案加入后，需要排除重复的 -1 和 3
                    left++;
                    right--; // 首先无论如何先要进行加减操作
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {  // nums[left] + nums[right] > target
                    right--;
                }
            }
        }
        return ans;
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int delta = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            
        }
        return 0;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        return null;
    }


    @Test
    public void test() {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

}
