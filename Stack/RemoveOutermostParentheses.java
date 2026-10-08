class RemoveOutermostParentheses {
    public String removeOuterParentheses(String s) {

        StringBuilder result = new StringBuilder();
        int depth = 0;

        for (char c : s.toCharArray()) {

            if (c == '(') {
                // Append only if it is not an outermost opening parenthesis
                if (depth > 0) {
                    result.append(c);
                }
                depth++;

            } else {
                depth--;

                // Append only if it is not an outermost closing parenthesis
                if (depth > 0) {
                    result.append(c);
                }
            }
        }

        return result.toString();
    }
}

/*
 * Time Complexity: O(n)
 * We traverse the string once, processing each character in O(1) time.
 *
 * Space Complexity: O(n)
 * The StringBuilder stores the resulting string, which can contain O(n)
 * characters. The toCharArray() conversion also requires O(n) space.
 */
