/**
 * Longest Common Substring
 *
 * Problem:
 * Find the length of the longest substring that is common to both strings.
 *
 * Important:
 * - Substring means characters must be contiguous.
 * - This is different from Longest Common Subsequence (LCS),
 *   where characters do not need to be contiguous.
 *
 * Approach:
 * Dynamic Programming
 *
 * dp[i][j] = length of the longest common substring
 *            ending at s1[i - 1] and s2[j - 1].
 *
 * If characters match:
 *      dp[i][j] = 1 + dp[i - 1][j - 1]
 *
 * If characters do not match:
 *      dp[i][j] = 0
 *
 * We maintain 'ans' to store the maximum value found.
 *
 * Time Complexity: O(n * m)
 * Space Complexity: O(n * m)
 *
 * where:
 * n = length of s1
 * m = length of s2
 */

class Solution {

    public int longestCommonSubstring(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        // DP table
        int[][] dp = new int[n + 1][m + 1];

        int ans = 0;

        // Build the DP table
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                // Compare current characters
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {

                    // Extend the previous common substring
                    dp[i][j] = 1 + dp[i - 1][j - 1];

                    // Update maximum length
                    ans = Math.max(ans, dp[i][j]);

                } else {

                    // Substring must be continuous,
                    // so reset the value to 0.
                    dp[i][j] = 0;
                }
            }
        }

        return ans;
    }
}