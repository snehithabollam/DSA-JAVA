import java.util.*;

public class NumberofOccurrence {

    // Finds the first occurrence of target using binary search.
    private static int findFirst(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int first = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                first = mid;
                high = mid - 1; // Continue searching on the left
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return first;
    }

    // Finds the last occurrence of target using binary search.
    private static int findLast(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int last = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                last = mid;
                low = mid + 1; // Continue searching on the right
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return last;
    }

    // Returns the number of occurrences of target.
    public static int countFreq(int[] arr, int target) {
        int first = findFirst(arr, target);

        // Target is not present in the array.
        if (first == -1) {
            return 0;
        }

        int last = findLast(arr, target);

        // Number of occurrences = last index - first index + 1
        return last - first + 1;
    }

    /*
     * Time Complexity: O(log n)
     * - Find first occurrence: O(log n)
     * - Find last occurrence: O(log n)
     * - Overall: O(log n)
     *
     * Space Complexity: O(1)
     * - Only constant extra variables are used.
     */

    public static void main(String[] args) {

        int[] arr = {1, 1, 2, 2, 2, 2, 3};
        int target = 2;

        int result = countFreq(arr, target);

        System.out.println("Number of occurrences: " + result);
    }
}