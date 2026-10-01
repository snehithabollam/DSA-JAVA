/**
 * Problem: Edit Distance
 *
 * Given two strings, find the minimum number of operations required
 * to convert word1 into word2.
 *
 * Allowed Operations:
 * 1. Insert a character
 * 2. Delete a character
 * 3. Replace a character
 *
 * Approach:
 * Dynamic Programming
 *
 * dp[i][j] = minimum number of operations required to convert
 *            first i characters of word1 into first j characters
 *            of word2.
 *
 * If characters are equal:
 *     dp[i][j] = dp[i - 1][j - 1]
 *
 * Otherwise, choose the minimum of:
 *     Insert  -> dp[i][j - 1]
 *     Delete  -> dp[i - 1][j]
 *     Replace -> dp[i - 1][j - 1]
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 *
 * where:
 * m = length of word1
 * n = length of word2
 */

class Solution {

    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        // DP table
        int[][] dp = new int[m + 1][n + 1];

        // Convert first i characters of word1
        // into an empty string.
        // This requires i deletions.
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        // Convert an empty string into
        // first j characters of word2.
        // This requires j insertions.
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                // If characters are equal,
                // no operation is required.
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {

                    dp[i][j] = dp[i - 1][j - 1];

                } else {

                    // Insert a character
                    int insert = dp[i][j - 1];

                    // Delete a character
                    int delete = dp[i - 1][j];

                    // Replace a character
                    int replace = dp[i - 1][j - 1];

                    // Choose the minimum operation
                    dp[i][j] = 1 + Math.min(
                        replace,
                        Math.min(insert, delete)
                    );
                }
            }
        }

        return dp[m][n];
    }
}