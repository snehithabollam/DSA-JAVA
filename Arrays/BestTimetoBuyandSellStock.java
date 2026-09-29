/**
 * LeetCode 121: Best Time to Buy and Sell Stock
 *
 * Approach:
 * - Keep track of the minimum stock price seen so far.
 * - For each price, calculate the profit if we sell on that day.
 * - Keep track of the maximum profit obtained.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class BestTimetoBuyandSellStock {

    public int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {

            // Update the minimum price seen so far
            minPrice = Math.min(minPrice, price);

            // Calculate profit if we sell at today's price
            int currentProfit = price - minPrice;

            // Update maximum profit
            maxProfit = Math.max(maxProfit, currentProfit);
        }

        return maxProfit;
    }
}