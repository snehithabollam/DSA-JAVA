class ValidParenthesesString {
    public boolean checkValidString(String s) {

        int minOpen = 0;
        int maxOpen = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                minOpen++;
                maxOpen++;
            } else if (ch == ')') {
                minOpen--;
                maxOpen--;
            } else { // '*' can represent '(', ')' or an empty string
                minOpen--;
                maxOpen++;
            }

            // Too many closing parentheses
            if (maxOpen < 0) {
                return false;
            }

            // Minimum possible unmatched opening parentheses cannot be negative
            minOpen = Math.max(minOpen, 0);
        }

        // Valid if zero unmatched opening parentheses is possible
        return minOpen == 0;
    }
}

/*
 * Approach: Greedy
 *
 * Time Complexity: O(n)
 * We traverse the string once, processing each character in O(1) time.
 *
 * Space Complexity: O(1)
 * We use only two integer variables, regardless of the input size.
 */