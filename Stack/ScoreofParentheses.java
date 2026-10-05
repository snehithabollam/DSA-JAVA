import java.util.Stack;

class Solution {

    /*
     * LeetCode 856: Score of Parentheses
     *
     * Approach:
     * - Use a stack to store scores of nested parentheses.
     * - Push 0 whenever '(' is encountered.
     * - When ')' is encountered:
     *      - Pop the inner score.
     *      - If inner score is 0, "()" contributes 1.
     *      - Otherwise, "(A)" contributes 2 * A.
     *      - Add this score to the previous level.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */

    public int scoreOfParentheses(String s) {

        Stack<Integer> stack = new Stack<>();

        // Base score
        stack.push(0);

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                // Start a new nested level
                stack.push(0);

            } else {
                // Get score inside current parentheses
                int innerScore = stack.pop();

                int score = (innerScore == 0)
                        ? 1
                        : 2 * innerScore;

                // Add current score to previous level
                stack.push(stack.pop() + score);
            }
        }

        return stack.pop();
    }
}