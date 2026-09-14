public class Findsquarerootofanumber {

    /**
     * Finds the floor of the square root of n using Binary Search.
     *
     * Example:
     * n = 28 -> returns 5
     * because 5 * 5 <= 28 and 6 * 6 > 28
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static int floorSqrt(int n) {

        if (n < 2) {
            return n;
        }

        int low = 1;
        int high = n / 2;
        int ans = 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Use n / mid instead of mid * mid to avoid integer overflow
            if (mid <= n / mid) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}