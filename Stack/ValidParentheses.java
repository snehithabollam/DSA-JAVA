import java.util.Stack;
/**
 * Problem: Valid Parentheses
 *
 * Given a string containing '(', ')', '{', '}', '[' and ']',
 * determine whether the brackets are valid.
 *
 * A valid string must satisfy:
 * 1. Every opening bracket has a corresponding closing bracket.
 * 2. Brackets are closed in the correct order.
 *
 * Approach:
 * - Use a Stack to store opening brackets.
 * - When an opening bracket is found, push it onto the stack.
 * - When a closing bracket is found:
 *      1. Check if the stack is empty.
 *      2. Pop the most recent opening bracket.
 *      3. Check whether it matches the closing bracket.
 * - At the end, the stack must be empty.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * where n = length of the string.
 */

class ValidParentheses {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            // Push opening brackets onto the stack
            if (c == '(' || c == '{' || c == '[') {

                stack.push(c);

            } else {

                // Closing bracket without an opening bracket
                if (stack.isEmpty()) {
                    return false;
                }

                // Get the most recent opening bracket
                char top = stack.pop();

                // Check whether brackets match
                if ((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{')) {

                    return false;
                }
            }
        }

        // Valid only if all opening brackets were matched
        return stack.isEmpty();
    }
}