/**
 * Problem: Distinct Subsequences
 *
 * Approach:
 * Dynamic Programming
 *
 * dp[i][j] = number of distinct subsequences of the first i characters
 *            of s that form the first j characters of t.
 *
 * If characters match:
 *     We have two choices:
 *     1. Use the current character from s.
 *     2. Ignore the current character from s.
 *
 *     dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
 *
 * If characters don't match:
 *     We cannot use the current character from s.
 *
 *     dp[i][j] = dp[i - 1][j]
 *
 * Base Cases:
 *     dp[i][0] = 1
 *     An empty string t can be formed by deleting all characters from s
 *     in exactly one way.
 *
 *     dp[0][j] = 0 for j > 0
 *     An empty s cannot form a non-empty t.
 *
 * Time Complexity: O(n * m)
 * Space Complexity: O(n * m)
 *
 * where:
 * n = length of s
 * m = length of t
 */

class Solution {

    int[][] dp;

    public int numDistinct(String s, String t) {

        int n = s.length();
        int m = t.length();

        // DP table
        dp = new int[n + 1][m + 1];

        // Base case:
        // There is exactly one way to form an empty t.
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // dp[0][j] is already 0 for j > 0
        // because Java initializes int arrays with 0.

        // Fill the DP table
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                char ch1 = s.charAt(i - 1);
                char ch2 = t.charAt(j - 1);

                if (ch1 == ch2) {

                    // Two choices:
                    // 1. Match the current characters
                    // 2. Skip the current character of s
                    dp[i][j] = dp[i - 1][j - 1]
                             + dp[i - 1][j];

                } else {

                    // Skip the current character of s
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][m];
    }
}