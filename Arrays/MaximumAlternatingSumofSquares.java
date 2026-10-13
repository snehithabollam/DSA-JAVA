import java.util.Arrays;

class Solution {

    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] squares = new long[n];

        // Calculate the square of each element.
        // Convert to long before multiplication to avoid integer overflow.
        for (int i = 0; i < n; i++) {
            squares[i] = (long) nums[i] * nums[i];
        }

        // Sort squared values in ascending order.
        Arrays.sort(squares);

        long score = 0L;
        int half = n / 2;

        // Subtract the smallest floor(n / 2) squared values.
        for (int i = 0; i < half; i++) {
            score -= squares[i];
        }

        // Add the remaining largest squared values.
        for (int i = half; i < n; i++) {
            score += squares[i];
        }

        return score;
    }
}

/*
 * Time Complexity: O(n log n)
 *   - Calculating squares: O(n)
 *   - Sorting the array: O(n log n)
 *   - Calculating the score: O(n)
 *
 * Space Complexity: O(n)
 *   - The squares array requires O(n) auxiliary space.
 */