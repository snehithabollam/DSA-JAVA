public class FindTwoNonoverlappingSubarraysEachWithTargetSum {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int INF = n + 1;

        // best[i] = minimum length of a valid subarray
        // found in the range [0 ... i]
        int[] best = new int[n];

        for (int i = 0; i < n; i++) {
            best[i] = INF;
        }

        int left = 0;
        int sum = 0;
        int answer = INF;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            // Shrink the window if the sum becomes greater than target
            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            // Current window has sum equal to target
            if (sum == target) {
                int currentLength = right - left + 1;

                // Find a non-overlapping subarray on the left
                if (left > 0 && best[left - 1] != INF) {
                    answer = Math.min(
                        answer,
                        currentLength + best[left - 1]
                    );
                }

                // Update the minimum length found so far
                if (right == 0) {
                    best[right] = currentLength;
                } else {
                    best[right] = Math.min(
                        best[right - 1],
                        currentLength
                    );
                }
            } else {
                // No valid subarray ending at 'right'
                if (right > 0) {
                    best[right] = best[right - 1];
                }
            }
        }

        return answer == INF ? -1 : answer;
    }

    /*
     * Time Complexity: O(n)
     * Each element is added to and removed from the
     * sliding window at most once.
     *
     * Space Complexity: O(n)
     * The best[] array stores the minimum subarray
     * length for every index.
     */
}
