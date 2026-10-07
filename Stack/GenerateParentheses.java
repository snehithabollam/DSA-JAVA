import java.util.*;
class GenerateParentheses {

    /*
     * Approach: Backtracking
     *
     * We generate all valid combinations of n pairs
     * of parentheses.
     *
     * Rules:
     * 1. We can add '(' as long as open < n.
     * 2. We can add ')' only when close < open.
     *    This ensures that the parentheses remain valid.
     *
     * Time Complexity:
     * O(Cn * n)
     *
     * Space Complexity:
     * O(Cn * n)
     *
     * Cn = nth Catalan number
     * Cn = (1 / (n + 1)) * (2n choose n)
     */

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();

        backtrack(result, new StringBuilder(), 0, 0, n);

        return result;
    }

    /*
     * Generates valid parentheses combinations using backtracking.
     *
     * open  = number of '(' used
     * close = number of ')' used
     */
    private void backtrack(List<String> result,
                           StringBuilder current,
                           int open,
                           int close,
                           int n) {

        // A complete valid combination has 2*n characters
        if (current.length() == 2 * n) {
            result.add(current.toString());
            return;
        }

        // Add '(' if we still have opening brackets available
        if (open < n) {

            current.append('(');

            backtrack(result, current, open + 1, close, n);

            // Backtrack: remove the last character
            current.deleteCharAt(current.length() - 1);
        }

        // Add ')' only if it will not make the string invalid
        if (close < open) {

            current.append(')');

            backtrack(result, current, open, close + 1, n);

            // Backtrack: remove the last character
            current.deleteCharAt(current.length() - 1);
        }
    }
}