
import java.util.*;

class Solution {

    private static final int MOD = 1_000_000_007;

    public int UniquePathsWithMirrors(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        long[][] dp = new long[m][n];

        int[] memo = new int[m * n * 2];
        Arrays.fill(memo, -2);

        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (dp[i][j] == 0) {
                    continue;
                }

                // Move right
                int right = resolve(
                    i, j + 1, 0, grid, memo, m, n
                );

                if (right != -1) {
                    int r = right / n;
                    int c = right % n;

                    dp[r][c] = (dp[r][c] + dp[i][j]) % MOD;
                }

                // Move down
                int down = resolve(
                    i + 1, j, 1, grid, memo, m, n
                );

                if (down != -1) {
                    int r = down / n;
                    int c = down % n;

                    dp[r][c] = (dp[r][c] + dp[i][j]) % MOD;
                }
            }
        }

        return (int) dp[m - 1][n - 1];
    }

    private int resolve(
        int r, int c, int dir,
        int[][] grid, int[] memo,
        int m, int n
    ) {

        ArrayList<Integer> path = new ArrayList<>();

        int result = 0;

        while (r >= 0 && r < m && c >= 0 && c < n) {

            // Empty cell: stop reflection
            if (grid[r][c] == 0) {
                result = r * n + c;
                break;
            }

            int id = (r * n + c) * 2 + dir;

            // Use previously calculated result
            if (memo[id] != -2) {
                result = memo[id];
                break;
            }

            path.add(id);

            // Change direction after hitting mirror
            if (dir == 0) {
                r++;
                dir = 1;
            } else {
                c++;
                dir = 0;
            }
        }

        // Robot goes outside the grid
        if (r < 0 || r >= m || c < 0 || c >= n) {
            result = -1;
        }

        // Store results in memoization array
        for (int k = path.size() - 1; k >= 0; k--) {
            memo[path.get(k)] = result;
        }

        return result;
    }
}

/*
Time Complexity: O(m * n)

Space Complexity: O(m * n)

Where:
m = number of rows
n = number of columns

DP array: O(m * n)
Memoization array: O(m * n)
*/
