/** LeetCode 2267 - Check if There Is a Valid Parentheses String Path
 *
 * Approach:
 * Use Dynamic Programming with Memoization.
 *
 * State:
 * dp[row][col][balance]
 *
 * balance represents the number of '(' minus the number of ')'
 * encountered along the current path.
 *
 * From each cell, we can move:
 * 1. Down
 * 2. Right
 *
 * A path is valid if:
 * - balance never becomes negative.
 * - balance is exactly 0 at the destination.
 *
 * Time Complexity: O(n * m * (n + m))
 * Space Complexity: O(n * m * (n + m))
 *
 * where:
 * n = number of rows
 * m = number of columns
 */

class CheckifthereisaVaildParentheses {

    private Boolean[][][] dp;

    public boolean hasValidPath(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        /*
         * A valid parentheses string must have even length.
         * Number of cells in any path = n + m - 1.
         */
        if ((n + m - 1) % 2 != 0) {
            return false;
        }

        /*
         * dp[row][col][balance]
         *
         * Maximum possible balance is n + m.
         */
        dp = new Boolean[n][m][n + m];

        return solve(grid, 0, 0, 0);
    }

    private boolean solve(char[][] grid, int row, int col, int balance) {

        // Out of bounds
        if (row >= grid.length || col >= grid[0].length) {
            return false;
        }

        // Update balance based on current character
        if (grid[row][col] == '(') {
            balance++;
        } else {
            balance--;
        }

        /*
         * If balance becomes negative, there are more ')' than '('.
         * Therefore, this path can never be valid.
         */
        if (balance < 0) {
            return false;
        }

        /*
         * If we reach the destination,
         * the parentheses string is valid only when balance == 0.
         */
        if (row == grid.length - 1 &&
            col == grid[0].length - 1) {

            return balance == 0;
        }

        // Return already computed result
        if (dp[row][col][balance] != null) {
            return dp[row][col][balance];
        }

        /*
         * Try both possible directions:
         * 1. Move down
         * 2. Move right
         */
        boolean down = solve(grid, row + 1, col, balance);
        boolean right = solve(grid, row, col + 1, balance);

        /*
         * If either path is valid, the current state is valid.
         */
        dp[row][col][balance] = down || right;

        return dp[row][col][balance];
    } 
}
