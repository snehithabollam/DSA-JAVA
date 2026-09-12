  import java.util.*;
public class FirstandLastinSorted {
    // Finds the first occurrence of x
    private int findFirst(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int first = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x) {
                first = mid;
                high = mid - 1; // Search on the left
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return first;
    }

    // Finds the last occurrence of x
    private int findLast(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int last = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x) {
                last = mid;
                low = mid + 1; // Search on the right
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return last;
    }

    public ArrayList<Integer> find(int[] arr, int x) {
        int first = findFirst(arr, x);
        int last = findLast(arr, x);

        ArrayList<Integer> result = new ArrayList<>();
        result.add(first);
        result.add(last);

        return result;
    }
/*Time Complexity: O(log n)
Space Complexity: O(1) */ 
}
