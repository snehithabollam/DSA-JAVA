/**
 * LeetCode 122: Best Time to Buy and Sell Stock II
 *
 * Approach:
 * Dynamic Programming - Bottom-Up
 *
 * We can perform multiple buy and sell transactions.
 *
 * State:
 * dp[ind][buy]
 *
 * buy = 1 -> We are allowed to buy
 * buy = 0 -> We are holding a stock and can sell
 *
 * Transitions:
 *
 * If buy == 1:
 *     Buy  -> -prices[ind] + dp[ind + 1][0]
 *     Skip -> dp[ind + 1][1]
 *
 * If buy == 0:
 *     Sell -> prices[ind] + dp[ind + 1][1]
 *     Skip -> dp[ind + 1][0]
 *
 * Base Case:
 * dp[n][0] = dp[n][1] = 0
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class BestTimetoBuyandSellStockII {

    public int maxProfit(int[] prices) {

        int n = prices.length;

        // dp[ind][buy]
        int[][] dp = new int[n + 1][2];

        // Base case:
        // No profit can be made after all days are completed.
        dp[n][0] = 0;
        dp[n][1] = 0;

        // Fill the DP table from right to left
        for (int ind = n - 1; ind >= 0; ind--) {

            for (int buy = 0; buy <= 1; buy++) {

                if (buy == 1) {

                    // Option 1: Buy the stock
                    // Option 2: Skip buying
                    dp[ind][buy] = Math.max(
                            -prices[ind] + dp[ind + 1][0],
                            dp[ind + 1][1]
                    );

                } else {

                    // Option 1: Sell the stock
                    // Option 2: Skip selling
                    dp[ind][buy] = Math.max(
                            prices[ind] + dp[ind + 1][1],
                            dp[ind + 1][0]
                    );
                }
            }
        }

        // Start from day 0 with permission to buy
        return dp[0][1];
    }
}
