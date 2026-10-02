/**
 * Problem: Longest Increasing Subsequence
 *
 * Approach:
 * Dynamic Programming - Bottom Up
 *
 * dp[i][prev + 1] represents the length of the longest increasing
 * subsequence starting from index i when the previous selected
 * element is at index prev.
 *
 * Since prev can be -1, we use prev + 1 as the DP column index.
 *
 * At every index i, we have two choices:
 *
 * 1. Skip nums[i]
 *      dp[i][prev + 1] = dp[i + 1][prev + 1]
 *
 * 2. Take nums[i]
 *      if prev == -1 OR nums[i] > nums[prev]
 *
 *      dp[i][prev + 1] =
 *          max(
 *              dp[i][prev + 1],
 *              1 + dp[i + 1][i + 1]
 *          )
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n^2)
 *
 * where n = length of nums.
 */

class LongestIncreasingSubsequence {

    int[][] dp;

    public int lengthOfLIS(int[] nums) {

        int n = nums.length;

        // dp[i][prev + 1]
        dp = new int[n + 1][n + 1];

        // Fill the table from bottom to top
        for (int i = n - 1; i >= 0; i--) {

            for (int prev = i - 1; prev >= -1; prev--) {

                // Option 1: Skip the current element
                dp[i][prev + 1] = dp[i + 1][prev + 1];

                // Option 2: Take the current element
                if (prev == -1 || nums[i] > nums[prev]) {

                    dp[i][prev + 1] = Math.max(
                        dp[i][prev + 1],
                        1 + dp[i + 1][i + 1]
                    );
                }
            }
        }

        // Start from index 0 with no previous element
        return dp[0][0];
    }
}
