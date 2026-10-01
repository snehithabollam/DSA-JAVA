/**
 * Problem: Delete Operation for Two Strings
 *
 * Approach:
 * - Find the Longest Common Subsequence (LCS) of word1 and word2.
 * - The characters in the LCS do not need to be deleted.
 * - All other characters must be deleted.
 *
 * Formula:
 * Minimum Deletions = n + m - (2 * LCS)
 *
 * Why?
 * - word1 requires n - LCS deletions.
 * - word2 requires m - LCS deletions.
 *
 * Total:
 * (n - LCS) + (m - LCS)
 * = n + m - 2 * LCS
 *
 * Time Complexity: O(n * m)
 * Space Complexity: O(n * m)
 *
 * where:
 * n = length of word1
 * m = length of word2
 */

class DeleteOperationForTwoStrings {

    int[][] dp;

    // Finds the Longest Common Subsequence
    int lcs(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();

        dp = new int[n + 1][m + 1];

        // Base cases are already 0 because
        // Java initializes integer arrays with 0.

        // Fill the DP table
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                char ch1 = text1.charAt(i - 1);
                char ch2 = text2.charAt(j - 1);

                if (ch1 == ch2) {

                    // Characters match
                    dp[i][j] = 1 + dp[i - 1][j - 1];

                } else {

                    // Characters don't match
                    dp[i][j] = Math.max(
                        dp[i - 1][j],
                        dp[i][j - 1]
                    );
                }
            }
        }

        return dp[n][m];
    }

    public int minDistance(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        // Find LCS
        int commonLength = lcs(word1, word2);

        // Minimum deletions required
        return n + m - (2 * commonLength);
    }
}
