package com.yunn.interview.interviewquestion.hot100;

/**
 * @date 2023/01/19
 */
public class Rob1 {


    // dp:
    //  dp[i]表示偷到第i间房子的最大金额
    //  间隔着偷，(n间房子，脚标从0->n-1)
    //    1. 偷最后一间，问题变成偷前n-1间房子的最大金额
    //    2. 不偷最后一间，问题变成偷前n-2间房子的最大金额 + 第n-1间房的金额
    //  返回max(1,2)
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[n + 1];
        dp[0] = 0;// 0间房子，所偷金额为0
        dp[1] = nums[0];// 1间房子，所偷最大金额为这间房子有的金额
        for (int i = 2; i <= nums.length; i++) {
            // 见1，2分析
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[n];
    }
}
