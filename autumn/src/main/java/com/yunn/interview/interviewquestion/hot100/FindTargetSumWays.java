package com.yunn.interview.interviewquestion.hot100;

/**
 * @author yunN
 * @date 2023/02/01.
 */
public class FindTargetSumWays {


    int ans = 0, t = 0;

    /*
        回溯： 每一个数字都有2种选择：+,-
        确定一个数字的组合然后向下dfs
     */
    public int findTargetSumWays(int[] nums, int target) {
        t = target;
        backtrack(0, nums, 0);
        return ans;
    }

    /*
        sum是当前遍历到当前位置前所有数字的和
     */
    private void backtrack(int start, int[] nums, int sum) {
        if (start == nums.length) {
            if (sum == t) {
                ans++;
            }
        } else {
            /*
                dfs数组中下一个数，对应的ops有2种：+/-
             */
            backtrack(start + 1, nums, sum + nums[start]);
            backtrack(start + 1, nums, sum - nums[start]);
        }
    }
}
