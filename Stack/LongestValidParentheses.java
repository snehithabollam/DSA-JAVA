import java.util.Stack;

class LongestValidParentheses{
    public int longestValidParentheses(String s) {

        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Base index for calculating valid length

        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();

                if (stack.isEmpty()) {
                    stack.push(i); // Update the base index
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }
}

/*
 * Time Complexity: O(n)
 * Each character is processed once, and each index is pushed
 * and popped from the stack at most once.
 *
 * Space Complexity: O(n)
 * The stack can store up to n + 1 indices in the worst case.
 */