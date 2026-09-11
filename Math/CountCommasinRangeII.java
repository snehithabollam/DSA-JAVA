public class CountCommasinRangeII {

    public long countCommas(long n) {

        long ans = 0;

        // Numbers from 1,000 onwards have at least 1 comma.
        if (n >= 1_000L) {
            ans += n - 999L;
        }

        // Numbers from 1,000,000 onwards have a second comma.
        if (n >= 1_000_000L) {
            ans += n - 999_999L;
        }

        // Numbers from 1,000,000,000 onwards have a third comma.
        if (n >= 1_000_000_000L) {
            ans += n - 999_999_999L;
        }

        // Numbers from 1,000,000,000,000 onwards have a fourth comma.
        if (n >= 1_000_000_000_000L) {
            ans += n - 999_999_999_999L;
        }

        // Numbers from 1,000,000,000,000,000 onwards have a fifth comma.
        if (n >= 1_000_000_000_000_000L) {
            ans += n - 999_999_999_999_999L;
        }

        return ans;
    }

    // Time Complexity: O(1)
    // Space Complexity: O(1)
}
