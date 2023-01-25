package com.yunn.interview.interviewquestion.hot100;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author yunN
 * @date 2023/01/18.
 */
public class CoinChange {


    /**
     * dp:
     *  dp[i]表示使用最少枚硬币能凑出的i
     *  dp[0] = 0, 意思是 金额为0，没有硬币数能满足
     *  遍历顺序自底向上（从小到大）
     */
    public int coinChange(int[] coins, int amount) {
        int n = amount + 1;
        int[] dp = new int[n];
        Arrays.fill(dp, n);
        dp[0] = 0;
        // 外层对amount从小到大进行遍历
        for (int i = 1; i < amount + 1; i++) {
            // 内层对coins进行遍历，不断组合硬币，得出使用最少硬币凑出1～amount的组合
            for (int j = 0; j < coins.length; j++) {
                // 只有当前币值小于当前amount时，才有可能存在"凑金额"的可能
                if (coins[j] <= i)
                    // 当前i的状态来自于 当前金额i - 当前币值 coin[j] + 1（表示这枚硬币）和 dp[i]本身的最小值
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        // 因为dp[amount]初始化时时一个比amount大的数，如果在所有的dp结束以后，还是比amount大，则说明没有对应的硬币组合能组成amount
        return dp[amount] > amount ? -1 : dp[amount];
    }

    @Test
    public void test() {
        coinChange(new int[]{1, 2, 5}, 11);
    }
}
