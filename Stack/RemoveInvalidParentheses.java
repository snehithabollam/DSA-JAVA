import java.util.*;

class RemoveInvalidParentheses {

    /*
     * Approach: Breadth-First Search (BFS)
     *
     * We remove one parenthesis at a time.
     * BFS guarantees that we find valid strings with
     * the minimum number of removals.
     *
     * Once we find valid strings at a particular level,
     * we do not generate strings from the next level.
     *
     * Time Complexity:
     * O(2^n * n)
     *
     * Space Complexity:
     * O(2^n * n)
     *
     * n = length of the input string
     */

    public List<String> removeInvalidParentheses(String s) {

        List<String> result = new ArrayList<>();

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        // Start BFS with the original string
        queue.offer(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {

            String current = queue.poll();

            // Check whether the current string is valid
            if (isValid(current)) {
                result.add(current);
                found = true;
            }

            /*
             * If a valid string is found at this level,
             * all further levels would require more removals.
             * Therefore, stop generating new strings.
             */
            if (found) {
                continue;
            }

            // Remove one parenthesis at each position
            for (int i = 0; i < current.length(); i++) {

                char ch = current.charAt(i);

                // Only remove '(' or ')'
                if (ch != '(' && ch != ')') {
                    continue;
                }

                String next = current.substring(0, i)
                        + current.substring(i + 1);

                // Avoid duplicate strings
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.offer(next);
                }
            }
        }

        return result;
    }

    /*
     * Checks whether the parentheses in the string are valid.
     */
    private boolean isValid(String s) {

        int balance = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                balance++;
            }
            else if (ch == ')') {
                balance--;

                // More closing brackets than opening brackets
                if (balance < 0) {
                    return false;
                }
            }
        }

        // Valid only when all opening brackets are closed
        return balance == 0;
    }
}