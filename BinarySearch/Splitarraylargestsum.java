public class Splitarraylargestsum {
    private boolean isPossible(int[] nums, int k, long maxSum) {

        long currentSum = 0;
        int subarrays = 1;

        for (int num : nums) {

            // A single element cannot fit within maxSum
            if (num > maxSum) {
                return false;
            }

            // Create a new subarray
            if (currentSum + num > maxSum) {
                subarrays++;
                currentSum = 0;
            }

            currentSum += num;

            // More than k subarrays are required
            if (subarrays > k) {
                return false;
            }
        }

        return true;
    }

    // Time Complexity: O(n * log(sum(nums)))
    // Space Complexity: O(1)
    public int splitArray(int[] nums, int k) {

        long low = 0;
        long high = 0;

        // Minimum possible answer = maximum element
        // Maximum possible answer = sum of all elements
        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        while (low <= high) {

            long mid = low + (high - low) / 2;

            if (isPossible(nums, k, mid)) {
                // Try to minimize the maximum subarray sum
                high = mid - 1;
            } else {
                // Need a larger maximum sum
                low = mid + 1;
            }
        }

        return (int) low;
    }
}
