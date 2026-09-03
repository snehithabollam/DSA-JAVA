class Solution {

    /**
     * Determines whether the given array can be made uniform
     * based on the parity of its elements.
     *
     * nums1 input integer array
     * true if the array is uniform, otherwise false
     */
    public boolean uniformArray(int[] nums1) {
        boolean hasOdd = false;
        boolean hasEven = false;
        int smallest = Integer.MAX_VALUE;

        for (int num : nums1) {
            smallest = Math.min(smallest, num);

            if (num % 2 == 0) {
                hasEven = true;
            } else {
                hasOdd = true;
            }
        }

        // If all elements have the same parity, the array is uniform.
        if (!hasOdd || !hasEven) {
            return true;
        }

        // If both odd and even elements exist, the smallest element
        // must be odd for the array to be uniform.
        //Time Complexity: O(n)
        //Space Complexity: O(1)
        return smallest % 2 != 0;
    }
}