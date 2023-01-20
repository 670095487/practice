package com.yunn.interview.interviewquestion.hot100;

import org.junit.Test;

/**
 * @date 2023/01/19
 */
public class Rob2 {


    /**
     * dp:
     * dp[i]表示第i间房偷到的最大金额
     * 1. 最后一间房不偷，问题转换为前 n-2 间房子能偷的最大金额
     * 2. 最后一间房偷，问题转化为第 2->n-1 间房子能偷的最大金额
     *
     * 脚标解释，dp数组比nums长度多1，dp[0]表示当前如果只有0间房子，最多能偷取的金额
     * 所以，当dp数组递增到i时,意味着nums的长度为i-1
     */
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[n + 1];
        // 最后一间不偷
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            // 把第n-1间看成第n间，所以是前n-1间能偷的最大金额
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }

        int[] dp2 = new int[n + 1];
        // 最后一间偷
        dp2[0] = 0;
        dp2[1] = 0;
        for (int i = 2; i <= nums.length; i++) {
            // 第n-1间是最后一间
            dp2[i] = Math.max(dp2[i - 2] + nums[i - 1], dp2[i - 1]);
        }

        return Math.max(dp[n - 1], dp2[n]);

    }

    @Test
    public void test() {
        rob(new int[]{2, 3, 2});
    }
}
