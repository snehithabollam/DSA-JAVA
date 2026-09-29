/**
 * LeetCode 123: Best Time to Buy and Sell Stock III
 *
 * Approach:
 * Dynamic Programming - Bottom-Up
 *
 * We are allowed to complete at most 2 transactions.
 * One transaction consists of:
 *     Buy -> Sell
 *
 * State:
 * dp[ind][buy][cap]
 *
 * ind -> Current day
 * buy -> 1 means we can buy, 0 means we can sell
 * cap -> Number of transactions remaining
 *
 * If buy == 1:
 *     Buy  -> -prices[ind] + dp[ind + 1][0][cap]
 *     Skip -> dp[ind + 1][1][cap]
 *
 * If buy == 0:
 *     Sell -> prices[ind] + dp[ind + 1][1][cap - 1]
 *     Skip -> dp[ind + 1][0][cap]
 *
 * Base Case:
 * dp[n][buy][cap] = 0
 *
 * Time Complexity: O(n * 2 * 2) = O(n)
 * Space Complexity: O(n * 2 * 3) = O(n)
 */

class Solution {

    public int maxProfit(int[] prices) {

        int n = prices.length;

        // dp[day][buy][transactions remaining]
        int[][][] dp = new int[n + 1][2][3];

        // Fill the DP table from the last day to the first
        for (int ind = n - 1; ind >= 0; ind--) {

            for (int buy = 0; buy <= 1; buy++) {

                for (int cap = 1; cap <= 2; cap++) {

                    if (buy == 1) {

                        // Option 1: Buy the stock
                        // Option 2: Skip buying
                        dp[ind][buy][cap] = Math.max(
                                -prices[ind] + dp[ind + 1][0][cap],
                                dp[ind + 1][1][cap]
                        );

                    } else {

                        // Option 1: Sell the stock
                        // Option 2: Skip selling
                        dp[ind][buy][cap] = Math.max(
                                prices[ind] + dp[ind + 1][1][cap - 1],
                                dp[ind + 1][0][cap]
                        );
                    }
                }
            }
        }

        // Start from day 0 with permission to buy
        // and 2 transactions available
        return dp[0][1][2];
    }
}
