class Solution {
    public String maxSumOfSquares(int num, int sum) {
        // If sum exceeds the maximum possible digit sum, no valid number exists.
        if (sum > 9 * num || sum == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        // Greedily place 9s to maximize the sum of squared digits.
        while (sum >= 9) {
            result.append('9');
            sum -= 9;
        }

        // Place the remaining digit, if any.
        if (sum > 0) {
            result.append((char) ('0' + sum));
        }

        // Fill the remaining positions with zeros.
        while (result.length() < num) {
            result.append('0');
        }

        return result.toString();
    }
}

/*
Time Complexity: O(num)
Space Complexity: O(num)

Approach:
1. Return an empty string if sum == 0 or sum > 9 * num.
2. Add as many 9s as possible to maximize the score.
3. Append the remaining digit, if any.
4. Fill the remaining positions with zeros.
5. Return the resulting string.

Greedy Strategy:
Concentrating the digit sum into larger digits maximizes
the sum of squares. Placing larger digits first also
produces the maximum integer among optimal solutions.
*/