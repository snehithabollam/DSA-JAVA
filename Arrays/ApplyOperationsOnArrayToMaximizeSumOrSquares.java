import java.util.List;

class ApplyOperationsOnArrayToMaximizeSumOrSquares {
    public int maxSum(List<Integer> nums, int k) {
        final long MOD = 1_000_000_007L;

        // Count the number of set bits at each position
        long[] bits = new long[32];

        for (int num : nums) {
            for (int b = 0; b < 32; b++) {
                if (((num >> b) & 1) != 0) {
                    bits[b]++;
                }
            }
        }

        long ans = 0;

        // Construct k numbers with maximum possible sum of squares
        for (int i = 0; i < k; i++) {
            long value = 0;

            // Greedily use the highest available set bits
            for (int b = 31; b >= 0; b--) {
                if (bits[b] > 0) {
                    value |= (1L << b);
                    bits[b]--;
                }
            }

            // Add the square modulo MOD
            ans = (ans + (value * value) % MOD) % MOD;
        }

        return (int) ans;
    }
}

/*
 * Time Complexity: O(32 * n + 32 * k)
 * where n is the number of elements in nums.
 * Since 32 is constant, this simplifies to O(n + k).
 *
 * Space Complexity: O(32) = O(1)
 * The bits array has a fixed size of 32.
 */