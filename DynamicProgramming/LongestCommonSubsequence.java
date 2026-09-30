import java.util.Arrays;

/*
 * Problem: Longest Common Subsequence
 * LeetCode: 1143
 *
 * Approach:
 * ---------
 * We use Top-Down Dynamic Programming (Memoization).
 *
 * Let dp[ind1][ind2] represent the LCS length between:
 * text1[0...ind1] and text2[0...ind2].
 *
 * Cases:
 *
 * 1. If ind1 or ind2 becomes negative:
 *    There are no characters left, so return 0.
 *
 * 2. If text1[ind1] == text2[ind2]:
 *    Both characters are part of the LCS.
 *    Answer = 1 + LCS(ind1 - 1, ind2 - 1)
 *
 * 3. If characters are different:
 *    We try both possibilities:
 *    - Skip character from text1
 *    - Skip character from text2
 *
 *    Answer = max(
 *        LCS(ind1 - 1, ind2),
 *        LCS(ind1, ind2 - 1)
 *    )
 *
 * Time Complexity:
 * O(n * m)
 *
 * Space Complexity:
 * O(n * m) for the DP array
 * O(n + m) recursion stack in the worst case
 *
 * Overall Space Complexity:
 * O(n * m + n + m) = O(n * m)
 */

class LongestCommonSubsequence {

    // DP table for memoization
    int[][] dp;

    // Recursive function
    private int function(
            int ind1,
            int ind2,
            String text1,
            String text2
    ) {

        // Base case
        if (ind1 < 0 || ind2 < 0) {
            return 0;
        }

        // Return already calculated result
        if (dp[ind1][ind2] != -1) {
            return dp[ind1][ind2];
        }

        // If characters match
        if (text1.charAt(ind1) == text2.charAt(ind2)) {
            return dp[ind1][ind2] =
                    1 + function(
                            ind1 - 1,
                            ind2 - 1,
                            text1,
                            text2
                    );
        }

        // If characters don't match
        return dp[ind1][ind2] = Math.max(
                function(ind1 - 1, ind2, text1, text2),
                function(ind1, ind2 - 1, text1, text2)
        );
    }

    public int longestCommonSubsequence(
            String text1,
            String text2
    ) {

        int n = text1.length();
        int m = text2.length();

        // Create DP table
        dp = new int[n][m];

        // Initialize with -1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Start from the last characters
        return function(
                n - 1,
                m - 1,
                text1,
                text2
        );
    }
}
/*
 * Problem: Longest Common Subsequence
 * LeetCode: 1143
 *
 * Approach: Bottom-Up Dynamic Programming (Tabulation)
 *
 * dp[i][j] represents the length of the Longest Common Subsequence
 * between:
 *      text1[0 ... i-1]
 *      text2[0 ... j-1]
 *
 * If the current characters match:
 *      dp[i][j] = 1 + dp[i-1][j-1]
 *
 * If the current characters don't match:
 *      dp[i][j] = max(dp[i-1][j], dp[i][j-1])
 *
 * Time Complexity: O(n * m)
 * Space Complexity: O(n * m)
 */

class LongestCommonSubsequence {

    int[][] dp;

    public int longestCommonSubsequence(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();

        // DP table
        dp = new int[n + 1][m + 1];

        /*
         * Base cases:
         * If either string is empty, LCS length is 0.
         *
         * Java initializes int arrays with 0,
         * so explicit initialization is not required.
         */

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                char ch1 = text1.charAt(i - 1);
                char ch2 = text2.charAt(j - 1);

                // Characters match
                if (ch1 == ch2) {

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

        // Final answer
        return dp[n][m];
    }
}