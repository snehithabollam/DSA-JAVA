class CountCommasinRange {

    /**
     * Counts the number of commas that appear when writing
     * all numbers from 1 to n with standard comma formatting.
     *
     * Example:
     * n = 1000
     * Numbers with commas: 1000
     * Answer = 1
     *
     * n = 2500
     * Numbers with commas: 1000 to 2500
     * Answer = 1501
     *
     * n upper limit
     *return number of commas
     */
    public int countCommas(int n) {

        // Numbers below 1000 do not contain commas.
        if (n < 1000) {
            return 0;
        }

        // Every number from 1000 to n contains exactly one comma.
        return n - 999;
    }

    // Time Complexity: O(1)
    // Space Complexity: O(1)
}