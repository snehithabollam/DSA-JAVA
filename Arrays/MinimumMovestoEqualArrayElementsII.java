import java.util.Arrays;

class Solution {
    public int minMoves2(int[] nums) {
        // Sort the array
        Arrays.sort(nums);

        // Find the median
        int median = nums[nums.length / 2];

        int moves = 0;

        // Calculate total moves to make all elements equal
        for (int num : nums) {
            moves += Math.abs(num - median);
        }

        return moves;
    }
}

/*
 * Time Complexity: O(n log n)
 * - Sorting the array takes O(n log n).
 * - Traversing the array takes O(n).
 *
 * Space Complexity: O(log n)
 * - Sorting stack space (depends on Java's sorting implementation).
 */