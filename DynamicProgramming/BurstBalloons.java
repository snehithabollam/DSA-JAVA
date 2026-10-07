class SBurstBalloons {

    public int maxCoins(int[] nums) {

        int n = nums.length;

        // Add virtual balloons with value 1 at both ends.
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        // dp[i][j] = maximum coins obtained by bursting
        // all balloons from index i to j.
        int[][] dp = new int[n + 2][n + 2];

        // Consider intervals of increasing length.
        for (int len = 1; len <= n; len++) {

            for (int i = 1; i + len - 1 <= n; i++) {

                int j = i + len - 1;

                // Try every balloon k as the LAST balloon to burst
                // in the range [i, j].
                for (int k = i; k <= j; k++) {

                    int coins = arr[i - 1] * arr[k] * arr[j + 1]
                              + dp[i][k - 1]
                              + dp[k + 1][j];

                    dp[i][j] = Math.max(dp[i][j], coins);
                }
            }
        }

        return dp[1][n];
    }
}

/*
    Time Complexity:
    O(N^3)

    - There are O(N^2) subarrays/intervals.
    - For each interval, we try O(N) possible last balloons.
    - Therefore, total time = O(N^3).

    Space Complexity:
    O(N^2)

    - The DP table requires O(N^2) space.
    - The auxiliary array requires O(N) space.
    - Overall space complexity = O(N^2).
*/
