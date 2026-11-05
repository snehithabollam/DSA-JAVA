import java.util.Arrays;

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {

        Arrays.sort(arr2);

        int count = 0;

        for (int num : arr1) {
            int low = 0;
            int high = arr2.length - 1;
            boolean valid = true;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (Math.abs(num - arr2[mid]) <= d) {
                    valid = false;
                    break;
                } 
                else if (arr2[mid] < num) {
                    low = mid + 1;
                } 
                else {
                    high = mid - 1;
                }
            }

            if (valid) {
                count++;
            }
        }

        return count;
    }
}

/*
Time Complexity: O(n log n + m log m)
    - Sorting arr2: O(m log m)
    - Binary search for each arr1 element: O(n log m)

Space Complexity: O(log m) auxiliary space
    - Depends on Java's sorting implementation.
*/