
/*
 * LeetCode 2333: Minimum Sum of Squared Difference
 *
 * Approach: Greedy + Frequency Counting
 *
 * Time Complexity: O(n + D)
 * Space Complexity: O(n + D)
 *
 * n = length of the arrays
 * D = maximum absolute difference between corresponding elements
 */

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {

        long k = (long) k1 + k2;
        int n = nums1.length;
        int maxDiff = 0;

        int[] diff = new int[n];

        // Calculate absolute differences
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
        }

        // If all differences are zero
        if (maxDiff == 0) {
            return 0L;
        }

        // Count occurrences of each difference
        long[] freq = new long[maxDiff + 1];

        for (int d : diff) {
            freq[d]++;
        }

        // Greedily reduce the largest differences
        for (int d = maxDiff; d > 0 && k > 0; d--) {

            long count = freq[d];

            if (count == 0) {
                continue;
            }

            // Operations needed to reduce all these differences by 1
            if (k >= count) {
                freq[d - 1] += count;
                freq[d] = 0;
                k -= count;
            } else {
                // Reduce only k elements by 1
                freq[d] -= k;
                freq[d - 1] += k;
                k = 0;
            }
        }

        // Calculate the sum of squared differences
        long result = 0;

        for (int d = 0; d < freq.length; d++) {
            result += freq[d] * d * d;
        }

        return result;
    }
}
