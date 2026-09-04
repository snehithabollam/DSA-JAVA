public class SmallestStableIndexI {
    /*
     * Finds the first index i such that:
     * max(nums[0...i]) - min(nums[i...n-1]) <= k
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     */
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        // Stores the difference for each index.
        int[] stable = new int[n];

        // Maximum value from the left side up to the current index.
        int largest = nums[0];

        for (int i = 0; i < n; i++) {

            // Update the maximum value seen so far.
            largest = Math.max(largest, nums[i]);

            // Find the minimum value from index i to the end.
            int smallest = Integer.MAX_VALUE;

            for (int j = i; j < n; j++) {
                smallest = Math.min(smallest, nums[j]);
            }

            // Difference between the prefix maximum
            // and suffix minimum.
            stable[i] = largest - smallest;
        }

        // Return the first index where the difference is <= k.
        for (int i = 0; i < n; i++) {
            if (stable[i] <= k) {
                return i;
            }
        }

        // No stable index found.
        return -1;
    } 
}
