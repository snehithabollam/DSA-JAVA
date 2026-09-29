/**
 * LeetCode 309: Best Time to Buy and Sell Stock with Cooldown
 *
 * Approach:
 * Dynamic Programming - Bottom-Up
 *
 * We can perform multiple transactions, but after selling a stock,
 * we must wait for one cooldown day before buying again.
 *
 * State:
 * dp[ind][buy]
 *
 * buy = 1 -> We are allowed to buy
 * buy = 0 -> We are holding a stock and can sell
 *
 * If buy == 1:
 *     Buy  -> -prices[ind] + dp[ind + 1][0]
 *     Skip -> dp[ind + 1][1]
 *
 * If buy == 0:
 *     Sell -> prices[ind] + dp[ind + 2][1]
 *     Skip -> dp[ind + 1][0]
 *
 * After selling on day ind, we move to ind + 2
 * because the next day is the cooldown day.
 *
 * Base Case:
 * dp[n][0] = dp[n][1] = 0
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {

    public int maxProfit(int[] prices) {

        int n = prices.length;

        // dp[ind][buy]
        // Extra two rows are used because selling accesses ind + 2.
        int[][] dp = new int[n + 2][2];

        // Fill the DP table from the last day to the first
        for (int ind = n - 1; ind >= 0; ind--) {

            // Option 1: Buy
            // Option 2: Skip buying
            dp[ind][1] = Math.max(
                    -prices[ind] + dp[ind + 1][0],
                    dp[ind + 1][1]
            );

            // Option 1: Sell and take a cooldown day
            // Option 2: Skip selling
            dp[ind][0] = Math.max(
                    prices[ind] + dp[ind + 2][1],
                    dp[ind + 1][0]
            );
        }

        // Start from day 0 with permission to buy
        return dp[0][1];
    }
}
