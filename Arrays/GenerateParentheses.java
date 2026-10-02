import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Generate Parentheses
 *
 * Given n pairs of parentheses, generate all combinations
 * of well-formed parentheses.
 *
 * Approach:
 * Backtracking
 *
 * We maintain:
 * - open  = number of '(' used
 * - close = number of ')' used
 *
 * Rules:
 * 1. We can add '(' if open < n.
 * 2. We can add ')' only if close < open.
 *
 * The second rule ensures that we never have more closing
 * parentheses than opening parentheses at any point.
 *
 * Time Complexity: O(Cn * n)
 * Space Complexity: O(Cn * n)
 *
 * where Cn is the nth Catalan number:
 *
 * Cn = (1 / (n + 1)) * (2n choose n)
 *
 * We generate Cn valid combinations, and each string
 * contains 2n characters.
 */

class GenerateParentheses {

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();

        StringBuilder current = new StringBuilder();

        backtrack(result, current, 0, 0, n);

        return result;
    }

    private void backtrack(List<String> result,
                           StringBuilder current,
                           int open,
                           int close,
                           int n) {

        // A complete valid combination is formed
        if (current.length() == 2 * n) {
            result.add(current.toString());
            return;
        }

        // Add an opening parenthesis if available
        if (open < n) {

            current.append('(');

            backtrack(
                result,
                current,
                open + 1,
                close,
                n
            );

            // Backtrack
            current.deleteCharAt(current.length() - 1);
        }

        // Add a closing parenthesis only when
        // there is an unmatched opening parenthesis
        if (close < open) {

            current.append(')');

            backtrack(
                result,
                current,
                open,
                close + 1,
                n
            );

            // Backtrack
            current.deleteCharAt(current.length() - 1);
        }
    }
}
