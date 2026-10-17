import java.util.Arrays;

class Solution {

    // Calculate the sum of digits of a number.
    private int digitSum(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;

        // Store each number along with its original index.
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = digitSum(nums[i]);
            arr[i][2] = i;
        }

        // Sort by digit sum, then by number in increasing order.
        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        boolean[] visited = new boolean[n];
        int swaps = 0;

        // Count the swaps needed to resolve each permutation cycle.
        for (int i = 0; i < n; i++) {
            if (visited[i] || arr[i][2] == i) {
                continue;
            }

            int cycleLength = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = arr[j][2];
                cycleLength++;
            }

            if (cycleLength > 1) {
                swaps += cycleLength - 1;
            }
        }

        return swaps;
    }
}

/*
Time Complexity: O(n log n)
    Sorting takes O(n log n), and cycle detection takes O(n).

Space Complexity: O(n)
    Stores the sorted elements, original indices, and visited array.
*/