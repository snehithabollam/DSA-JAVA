class SumofSquaresofSpecialElements {
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int sum = 0;

        // Check each position (1-based indexing)
        for (int i = 1; i <= n; i++) {
            // If i divides n, add the square of nums[i - 1]
            if (n % i == 0) {
                sum += nums[i - 1] * nums[i - 1];
            }
        }

        return sum;
    }
}

/*
 * Time Complexity: O(n)
 * We iterate through the array once.
 *
 * Space Complexity: O(1)
 * We use only a constant amount of extra space.
 */
