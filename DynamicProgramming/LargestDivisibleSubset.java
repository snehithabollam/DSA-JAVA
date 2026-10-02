import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Problem: Largest Divisible Subset
 *
 * Given a set of distinct positive integers, find the largest subset
 * such that for every pair (Si, Sj):
 *
 *     Si % Sj == 0 OR Sj % Si == 0
 *
 * Approach:
 * - Sort the array.
 * - Use Dynamic Programming similar to Longest Increasing Subsequence.
 * - dp[i] stores the size of the largest divisible subset ending at i.
 * - hash[i] stores the previous index used to construct that subset.
 * - After finding the largest subset, reconstruct the answer using hash[].
 *
 * Time Complexity:
 *     O(n^2 + n log n)
 *
 * Sorting: O(n log n)
 * DP:      O(n^2)
 * Result:  O(n)
 *
 * Overall: O(n^2)
 *
 * Space Complexity:
 *     O(n)
 *
 * dp[] and hash[] require O(n) extra space.
 */

class LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {

        int n = nums.length;

        // dp[i] = length of largest divisible subset ending at i
        int[] dp = new int[n];

        // hash[i] = previous index used to reconstruct the subset
        int[] hash = new int[n];

        // Sort the array
        Arrays.sort(nums);

        int maxLength = 1;
        int lastIndex = 0;

        // Build the DP table
        for (int i = 0; i < n; i++) {

            dp[i] = 1;
            hash[i] = i;

            for (int prev = 0; prev < i; prev++) {

                // Check divisibility
                if (nums[i] % nums[prev] == 0 &&
                    1 + dp[prev] > dp[i]) {

                    dp[i] = 1 + dp[prev];

                    // Store the previous index
                    hash[i] = prev;
                }
            }

            // Update the largest subset
            if (dp[i] > maxLength) {

                maxLength = dp[i];
                lastIndex = i;
            }
        }

        // Reconstruct the largest divisible subset
        List<Integer> result = new ArrayList<>();

        while (hash[lastIndex] != lastIndex) {

            result.add(nums[lastIndex]);

            lastIndex = hash[lastIndex];
        }

        // Add the first element
        result.add(nums[lastIndex]);

        // We reconstructed backwards
        Collections.reverse(result);

        return result;
    }
}