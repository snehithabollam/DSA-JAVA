class Solution {
    public int minMoves(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        // Find maximum element and calculate sum
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        // Calculate minimum moves
        return nums.length * max - sum;
    }
}

/*
 * Time Complexity: O(n)
 * - Traverse the array once to find the maximum
 *   element and calculate the sum.
 *
 * Space Complexity: O(1)
 * - Uses only constant extra space.
 */