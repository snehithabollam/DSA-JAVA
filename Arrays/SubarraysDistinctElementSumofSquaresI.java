import java.util.*;

class Solution {
    private static final int MOD = 1_000_000_007;

    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        long result = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> distinct = new HashSet<>();

            for (int j = i; j < n; j++) {
                distinct.add(nums.get(j));

                long count = distinct.size();
                result = (result + count * count) % MOD;
            }
        }

        return (int) result;
    }
}

/*
 * Time Complexity: O(n^2) expected
 * Space Complexity: O(n)
 *
 * n = nums.size()
 */