/**
 * Problem: Shortest Common Supersequence
 *
 * Approach:
 * 1. Find the Longest Common Subsequence (LCS) of str1 and str2.
 * 2. Use the DP table to reconstruct the shortest supersequence.
 * 3. If characters match, add the character once.
 * 4. If they don't match, follow the direction with the larger LCS value.
 * 5. Add remaining characters from either string.
 * 6. Reverse the result because we build it from the end.
 *
 * Time Complexity: O(n * m)
 * Space Complexity: O(n * m)
 *
 * where:
 * n = length of str1
 * m = length of str2
 */

class Solution {

    int[][] dp;

    public String shortestCommonSupersequence(String str1, String str2) {

        int n = str1.length();
        int m = str2.length();

        // DP table for Longest Common Subsequence
        dp = new int[n + 1][m + 1];

        // Build the LCS table
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {

                    // Characters match
                    dp[i][j] = 1 + dp[i - 1][j - 1];

                } else {

                    // Take the maximum LCS length
                    dp[i][j] = Math.max(
                        dp[i - 1][j],
                        dp[i][j - 1]
                    );
                }
            }
        }

        // Reconstruct the Shortest Common Supersequence
        StringBuilder ans = new StringBuilder();

        int i = n;
        int j = m;

        while (i > 0 && j > 0) {

            // If characters are equal, add only once
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {

                ans.append(str1.charAt(i - 1));

                i--;
                j--;

            } else if (dp[i - 1][j] > dp[i][j - 1]) {

                // Take character from str1
                ans.append(str1.charAt(i - 1));
                i--;

            } else {

                // Take character from str2
                ans.append(str2.charAt(j - 1));
                j--;
            }
        }

        // Add remaining characters from str1
        while (i > 0) {

            ans.append(str1.charAt(i - 1));
            i--;
        }

        // Add remaining characters from str2
        while (j > 0) {

            ans.append(str2.charAt(j - 1));
            j--;
        }

        // We constructed the answer backwards
        return ans.reverse().toString();
    }
}