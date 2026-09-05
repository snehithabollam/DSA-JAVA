public class SmallestStableIndexII {
    /**
     * Finds the first index i such that the difference between the
     * maximum element in nums[0...i] and the minimum element in
     * nums[i...n-1] is at most k.
     *
     * nums input array
     * k maximum allowed difference
     * return first stable index, or -1 if no such index exists
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        // last[i] stores the minimum value in nums[i...n-1]
        int[] last = new int[n];

        last[n - 1] = nums[n - 1];

        // Build suffix minimum array
        for (int i = n - 2; i >= 0; i--) {
            last[i] = Math.min(last[i + 1], nums[i]);
        }

        // Track the maximum value in the prefix
        int largest = nums[0];

        for (int i = 0; i < n; i++) {
            largest = Math.max(largest, nums[i]);

            // Check if the prefix maximum and suffix minimum
            // differ by at most k
            if (largest - last[i] <= k) {
                return i;
            }
        }

        return -1;
    }
}
