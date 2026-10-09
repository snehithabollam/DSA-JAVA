/*
 * Problem: Minimum Insertions to Balance a Parentheses String
 * Approach: Greedy
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int minInsertions(String s) {

        int insertions = 0;
        int open = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {
                // Each opening parenthesis requires two closing parentheses
                open++;
            } else {

                // Check whether the next character is also ')'
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    // A complete closing pair is found
                    i++;
                } else {
                    // Insert one ')' to complete the closing pair
                    insertions++;
                }

                // Match the closing pair with an opening parenthesis
                if (open > 0) {
                    open--;
                } else {
                    // Insert '(' because no opening parenthesis is available
                    insertions++;
                }
            }
        }

        // Each unmatched '(' requires two closing parentheses
        insertions += open * 2;

        return insertions;
    }
}