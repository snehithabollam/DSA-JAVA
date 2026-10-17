import java.util.HashMap;
import java.util.Map;

class Solution {
    private static final int MOD = 1_000_000_007;

    private long[] sum;
    private long[] squareSum;
    private long[] lazy;
    private int size;

    public int sumCounts(int[] nums) {
        int n = nums.length;

        size = 1;
        while (size < n) {
            size <<= 1;
        }

        sum = new long[2 * size];
        squareSum = new long[2 * size];
        lazy = new long[2 * size];

        Map<Integer, Integer> lastOccurrence = new HashMap<>();
        long answer = 0;

        for (int i = 0; i < n; i++) {
            int value = nums[i];
            int previous = lastOccurrence.getOrDefault(value, -1);

            // Increase distinct counts for valid starting positions.
            update(1, 0, size - 1, previous + 1, i, 1);

            // Add squared distinct counts of subarrays ending at i.
            answer = (answer + query(1, 0, size - 1, 0, i)) % MOD;

            lastOccurrence.put(value, i);
        }

        return (int) answer;
    }

    private void apply(int node, int left, int right, long value) {
        long length = right - left + 1L;
        long oldSum = sum[node];

        // Update sum of squares:
        // (x + value)^2 = x^2 + 2*x*value + value^2
        squareSum[node] = (
            squareSum[node]
            + 2L * value % MOD * oldSum % MOD
            + length % MOD * value % MOD * value % MOD
        ) % MOD;

        // Update sum of values.
        sum[node] = (oldSum + length % MOD * value % MOD) % MOD;

        // Store lazy update.
        lazy[node] = (lazy[node] + value) % MOD;
    }

    private void push(int node, int left, int right) {
        if (lazy[node] == 0 || left == right) {
            return;
        }

        int mid = left + (right - left) / 2;

        apply(node * 2, left, mid, lazy[node]);
        apply(node * 2 + 1, mid + 1, right, lazy[node]);

        lazy[node] = 0;
    }

    private void update(int node, int left, int right,
                        int queryLeft, int queryRight, long value) {
        if (queryLeft > right || queryRight < left) {
            return;
        }

        if (queryLeft <= left && right <= queryRight) {
            apply(node, left, right, value);
            return;
        }

        push(node, left, right);

        int mid = left + (right - left) / 2;

        update(node * 2, left, mid, queryLeft, queryRight, value);
        update(node * 2 + 1, mid + 1, right,
               queryLeft, queryRight, value);

        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;

        squareSum[node] =
            (squareSum[node * 2] + squareSum[node * 2 + 1]) % MOD;
    }

    private long query(int node, int left, int right,
                       int queryLeft, int queryRight) {
        if (queryLeft > right || queryRight < left) {
            return 0;
        }

        if (queryLeft <= left && right <= queryRight) {
            return squareSum[node];
        }

        push(node, left, right);

        int mid = left + (right - left) / 2;

        long leftSum = query(
            node * 2, left, mid, queryLeft, queryRight
        );

        long rightSum = query(
            node * 2 + 1, mid + 1, right, queryLeft, queryRight
        );

        return (leftSum + rightSum) % MOD;
    }
}

/*
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 *
 * n = nums.length
 */