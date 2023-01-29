package com.yunn.interview.interviewquestion.hot100;

/**
 * @date 2023/01/29
 */
public class CanPartition {

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 奇数不可能被等分
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        /*
            dp[i][j]表示在[0,i]范围内是否有满足子集和为j的子集存在
            i初始定义为n 是因为i的取值范围是nums[i],是通过遍历数组得到的值
            j初始定义为target+1 是因为对于和j，有0~target种情况，因为下标是从0开始，所以+1
         */
        boolean[][] dp = new boolean[n][target + 1];

        // 初始化第一个位置，对于第一行第一个num只要考虑它本身自己的值能不能放进大小为target的背包即可
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                // 如果当前的nums[i]不满足以下所有的if(),那么当前的dp状态从上一个状态转移过来
                dp[i][j] = dp[i - 1][j];

                // 考虑当前的nums[i]
                // 正好相等说明可以满足条件
                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                // 如果小于，则当前的状态是从上一个位置转移过来
                if (nums[i] < j) dp[i][j] = dp[i - 1][j - nums[i]] || dp[i - 1][j];
            }
        }
        // 因为是正整数数组，所以只要能找到一组子集可以满足target就意味着这个数组可以被切分为2个相等子集
        return dp[n - 1][target];
    }
}
