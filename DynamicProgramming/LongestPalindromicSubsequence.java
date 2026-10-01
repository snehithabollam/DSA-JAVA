/**
 * Problem: Longest Palindromic Subsequence
 *
 * Approach:
 * 1. Reverse the given string.
 * 2. Find the LCS of the original string and its reverse.
 * 3. The LCS length gives the Longest Palindromic Subsequence length.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n^2)
 *
 * where n = length of the input string.
 */

class LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {

        // Reverse the input string
        String reversed = new StringBuilder(s).reverse().toString();

        int n = s.length();

        // DP table for LCS
        int[][] dp = new int[n + 1][n + 1];

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                if (s.charAt(i - 1) == reversed.charAt(j - 1)) {

                    // Matching characters
                    dp[i][j] = 1 + dp[i - 1][j - 1];

                } else {

                    // Take the maximum of previous possibilities
                    dp[i][j] = Math.max(
                        dp[i - 1][j],
                        dp[i][j - 1]
                    );
                }
            }
        }

        // Length of the Longest Palindromic Subsequence
        return dp[n][n];
    }
}