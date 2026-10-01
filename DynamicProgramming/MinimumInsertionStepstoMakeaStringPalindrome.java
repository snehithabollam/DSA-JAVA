/**
 * Problem: Minimum Insertion Steps to Make a String Palindrome
 *
 * Approach:
 * - Find the Longest Palindromic Subsequence (LPS).
 * - LPS can be found using LCS of the string and its reverse.
 * - Minimum insertions required = n - LPS
 *
 * Formula:
 *     Minimum Insertions = n - LPS
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n^2)
 *
 * where n = length of the string.
 */

class Solution {

    int[][] dp;

    // Finds the Longest Common Subsequence of two strings
    int lcs(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();

        dp = new int[n + 1][m + 1];

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

    public int minInsertions(String s) {

        int n = s.length();

        // Reverse the string
        String reversed = new StringBuilder(s)
                                .reverse()
                                .toString();

        // LPS = LCS of string and its reverse
        int lps = lcs(s, reversed);

        // Minimum insertions required
        return n - lps;
    }
}
