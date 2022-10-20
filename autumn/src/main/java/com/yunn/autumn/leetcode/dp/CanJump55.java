package com.yunn.autumn.leetcode.dp;

/**
 * @author yunN
 * @date 2022/10/19.
 */
public class CanJump55 {

    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 1; i < n; i++) {
            dp[i] = false;
            for (int j = 0; j < i; j++) {
                // 找出i之前任意一个元素可以到达i处就表明可以跳跃到目标处
                // condition2: 索引+数组中对应的值只要>=当前索引值就表示可以从此处跳跃到当前位置
                if (dp[j] && j + nums[j] >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n - 1];
    }
}
