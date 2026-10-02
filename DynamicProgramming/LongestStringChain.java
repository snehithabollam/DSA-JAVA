import java.util.Arrays;

/**
 * Problem: Longest String Chain
 *
 * A word can follow another word if it can be formed by adding
 * exactly one character to the previous word without changing
 * the order of the existing characters.
 *
 * Example:
 *     "a" -> "ba" -> "bca" -> "bdca"
 *
 * Approach:
 * 1. Sort words by their length.
 * 2. Use Dynamic Programming similar to LIS.
 * 3. dp[i] = longest string chain ending at words[i].
 * 4. For every previous word, check whether it is a valid
 *    predecessor of the current word.
 *
 * Time Complexity:
 *     O(n^2 * L)
 *
 * where:
 *     n = number of words
 *     L = maximum word length
 *
 * Sorting:
 *     O(n log n)
 *
 * Predecessor checking:
 *     O(L)
 *
 * Overall:
 *     O(n^2 * L)
 *
 * Space Complexity:
 *     O(n)
 *
 * The dp array requires O(n) extra space.
 */

class LongestStringChain{

    public int longestStrChain(String[] words) {

        // Sort words according to their length
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int n = words.length;

        // dp[i] = longest chain ending at words[i]
        int[] dp = new int[n];

        // Every word itself forms a chain of length 1
        Arrays.fill(dp, 1);

        int ans = 1;

        // Build the DP table
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {

                // Check if words[j] can be a predecessor
                // of words[i]
                if (isPredecessor(words[j], words[i])) {

                    dp[i] = Math.max(
                        dp[i],
                        dp[j] + 1
                    );
                }
            }

            // Update the maximum chain length
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    /**
     * Checks whether 'shorter' is a valid predecessor of 'longer'.
     *
     * A valid predecessor must:
     * - Have exactly one fewer character.
     * - Have all its characters appear in the same order
     *   inside the longer word.
     */
    private boolean isPredecessor(String shorter, String longer) {

        // Length must differ by exactly 1
        if (longer.length() != shorter.length() + 1) {
            return false;
        }

        int i = 0; // Pointer for shorter
        int j = 0; // Pointer for longer

        while (i < shorter.length() && j < longer.length()) {

            if (shorter.charAt(i) == longer.charAt(j)) {
                i++;
            }

            // Always move in the longer string
            j++;
        }

        // All characters of shorter were matched
        return i == shorter.length();
    }
}