class CapacitytoShipPackagesWithinDDays {

    private boolean isPossible(int[] weights, int days, int capacity) {

        int currentLoad = 0;
        int requiredDays = 1;

        for (int weight : weights) {

            // A single package cannot fit in the ship
            if (weight > capacity) {
                return false;
            }

            // Start loading on the next day
            if (currentLoad + weight > capacity) {
                requiredDays++;
                currentLoad = 0;
            }

            currentLoad += weight;

            // More days are required than available
            if (requiredDays > days) {
                return false;
            }
        }

        return true;
    }

    // Time Complexity: O(n * log(sum(weights)))
    // Space Complexity: O(1)
    public int shipWithinDays(int[] weights, int days) {

        int low = 0;
        int high = 0;

        // Minimum capacity = maximum weight
        // Maximum capacity = sum of all weights
        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (isPossible(weights, days, mid)) {
                // Try a smaller capacity
                high = mid - 1;
            } else {
                // Need a larger capacity
                low = mid + 1;
            }
        }

        return low;
    }
}