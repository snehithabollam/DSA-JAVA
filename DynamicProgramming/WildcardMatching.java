class WildcardMatching {

    int[][] dp;

    public boolean isMatch(String s, String p) {

        int n = s.length();
        int m = p.length();

        // dp[i][j] = 1 if first i characters of s
        // match first j characters of p, otherwise 0
        dp = new int[n + 1][m + 1];

        // Empty string matches empty pattern
        dp[0][0] = 1;

        // Empty string vs pattern
        // Only '*' can match an empty string
        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            } else {
                dp[0][j] = 0;
            }
        }

        // Non-empty string vs empty pattern
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 0;
        }

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                char ch1 = s.charAt(i - 1);
                char ch2 = p.charAt(j - 1);

                // Same character or '?' matches one character
                if (ch1 == ch2 || ch2 == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }

                // '*' has two choices:
                // 1. Match one or more characters -> dp[i-1][j]
                // 2. Match zero characters -> dp[i][j-1]
                else if (ch2 == '*') {
                    dp[i][j] = dp[i - 1][j] | dp[i][j - 1];
                }

                // Characters do not match
                else {
                    dp[i][j] = 0;
                }
            }
        }

        return dp[n][m] == 1;
    }

    /*
     * Time Complexity: O(n * m)
     *   - We fill an (n + 1) x (m + 1) DP table.
     *
     * Space Complexity: O(n * m)
     *   - We use a 2D DP array of size (n + 1) x (m + 1).
     */
}