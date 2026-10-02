/**
 * Problem: Number of Longest Increasing Subsequence
 *
 * Approach:
 * Dynamic Programming
 *
 * We maintain two arrays:
 *
 * dp[i]:
 *     Length of the Longest Increasing Subsequence
 *     ending at index i.
 *
 * count[i]:
 *     Number of LIS of length dp[i] ending at index i.
 *
 * For every previous index prev:
 *
 * If nums[i] > nums[prev]:
 *
 * 1. If we found a longer subsequence:
 *
 *      dp[prev] + 1 > dp[i]
 *
 *      Update the length and copy the number of ways:
 *
 *      dp[i] = dp[prev] + 1
 *      count[i] = count[prev]
 *
 * 2. If we found another subsequence of the same length:
 *
 *      dp[prev] + 1 == dp[i]
 *
 *      Add the number of ways:
 *
 *      count[i] += count[prev]
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 *
 * where n = length of nums.
 */

class NumberofLongestIncreasingSubsequence {

    public int findNumberOfLIS(int[] nums) {

        int n = nums.length;

        // dp[i] = LIS length ending at i
        int[] dp = new int[n];

        // count[i] = number of LIS ending at i
        int[] count = new int[n];

        // Every individual element is an LIS of length 1
        for (int i = 0; i < n; i++) {

            dp[i] = 1;
            count[i] = 1;
        }

        int maxLength = 1;

        // Build the DP arrays
        for (int i = 0; i < n; i++) {

            for (int prev = 0; prev < i; prev++) {

                // Current element can extend the subsequence
                if (nums[i] > nums[prev]) {

                    // Found a longer LIS
                    if (dp[prev] + 1 > dp[i]) {

                        dp[i] = dp[prev] + 1;

                        // Number of ways comes from prev
                        count[i] = count[prev];

                    }

                    // Found another LIS of the same length
                    else if (dp[prev] + 1 == dp[i]) {

                        count[i] += count[prev];
                    }
                }
            }

            // Update global maximum LIS length
            maxLength = Math.max(maxLength, dp[i]);
        }

        // Count all LIS having the maximum length
        int answer = 0;

        for (int i = 0; i < n; i++) {

            if (dp[i] == maxLength) {
                answer += count[i];
            }
        }

        return answer;
    }
}
