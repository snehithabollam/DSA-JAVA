
class Solution {
    public int MinimumMovesToEqualArrayElements(int[] nums) {
        int min = nums[0];
        int sum = 0;

        // Find the minimum element
        for (int num : nums) {
            min = Math.min(min, num);
        }

        // Calculate minimum moves
        for (int num : nums) {
            sum += num - min;
        }

        return sum;
    }
}

/*
Approach:
1. Find the minimum element in the array.
2. Calculate the difference between every element and the minimum.
3. The sum of these differences gives the minimum moves.

Time Complexity: O(n)
Space Complexity: O(1)

Where n = number of elements in the array.
*/
