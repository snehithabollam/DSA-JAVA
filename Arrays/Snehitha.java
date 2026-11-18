
class Solution {

    /**
     * Calculates the minimum cost required to satisfy both type 1
     * and type 2 requirements.
     *
     * param cost1    Cost of one type 1 item
     * param cost2    Cost of one type 2 item
     * param costBoth Cost of one item contributing to both types
     * param need1    Required units of type 1
     * param need2    Required units of type 2
     * return Minimum possible total cost
     *
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public long minimumCost(int cost1, int cost2, int costBoth,
                            int need1, int need2) {

        // Option 1: Purchase all items separately.
        long option1 = (long) need1 * cost1
                     + (long) need2 * cost2;

        // Option 2: Purchase only type 3 items.
        // Extra contribution to one requirement is allowed.
        long option2 = (long) Math.max(need1, need2) * costBoth;

        // Option 3: Purchase type 3 items for common requirements.
        long common = Math.min(need1, need2);

        long option3 = common * costBoth
                     + (long) (need1 - common) * Math.min(cost1, costBoth)
                     + (long) (need2 - common) * Math.min(cost2, costBoth);

        // Return the minimum cost among all three strategies.
        return Math.min(option1, Math.min(option2, option3));
    }
}
