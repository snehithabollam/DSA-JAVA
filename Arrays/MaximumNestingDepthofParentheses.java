public class MaximumNestingDepthofParentheses {
    public int maxDepth(String s) {
        int depth = 0;
        int maxDepth = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                depth++;
                maxDepth = Math.max(maxDepth, depth);

            } else if (ch == ')') {
                depth--;
            }
        }

        return maxDepth;
    }

/*
Time Complexity: O(n)
- We traverse the string once.
- n = length of the string.

Space Complexity: O(n)
- toCharArray() creates a character array of size n.
- If we iterate using charAt(), auxiliary space can be O(1).
*/
}
