public class ConstructUniformParityArray {
    public boolean uniformArray(int[] nums1) {
        int countOdd = 0;

        // Count the number of odd elements
        for (int num : nums1) {
            if ((num & 1) != 0) {
                countOdd++;
            }
        }

        // We can make all elements even if:
        // - All elements are already even, or
        // - There are at least two odd elements
        boolean canAllEven = (countOdd == 0) || (countOdd >= 2);

        // We can make all elements odd if there is at least one odd element
        boolean canAllOdd = (countOdd >= 1);

        return canAllEven || canAllOdd;
    }

    /*
     * Time Complexity: O(n)
     * - We traverse the array once to count odd elements.
     *
     * Space Complexity: O(1)
     * - Only a constant amount of extra space is used.
     */
}
