class FindNthrootofanumber {

    private int fun(int mid, int n, int m) {

        long ans = 1;

        for (int i = 1; i <= n; i++) {

            ans = ans * mid;

            // mid^n is greater than m
            if (ans > m) {
                return 2;
            }
        }

        // mid^n is equal to m
        if (ans == m) {
            return 1;
        }

        // mid^n is less than m
        return 0;
    }

    // Time Complexity: O(n * log m)
    // Space Complexity: O(1)
    public int nthRoot(int n, int m) {

        // Special case: nth root of 0 is 0
        if (m == 0) {
            return 0;
        }

        int low = 1;
        int high = m;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int result = fun(mid, n, m);

            if (result == 1) {
                return mid;
            }
            else if (result == 2) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
