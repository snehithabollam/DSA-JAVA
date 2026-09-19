public class NumberofOccurrence {

    private static int findFirst(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int first = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                first = mid;
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return first;
    }

    private static int findLast(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int last = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                last = mid;
                low = mid + 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return last;
    }

    public static int countFreq(int[] arr, int target) {
        int first = findFirst(arr, target);

        if (first == -1) {
            return 0;
        }

        int last = findLast(arr, target);

        return last - first + 1;
    }

    /*
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 2, 3};
        int target = 2;

        int result = countFreq(arr, target);

        System.out.println("Number of occurrences: " + result);
    }
}