class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;

        // Arrays to store the elements distributed from nums
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        // Current sizes of arr1 and arr2
        int size1 = 1;
        int size2 = 1;

        // First element goes to arr1
        arr1[0] = nums[0];

        // Second element goes to arr2
        arr2[0] = nums[1];

        // Distribute the remaining elements
        for (int i = 2; i < n; i++) {
            if (arr1[size1 - 1] > arr2[size2 - 1]) {
                arr1[size1++] = nums[i];
            } else {
                arr2[size2++] = nums[i];
            }
        }

        // Concatenate arr1 and arr2 into result
        int[] result = new int[n];

        for (int i = 0; i < size1; i++) {
            result[i] = arr1[i];
        }

        for (int i = 0; i < size2; i++) {
            result[size1 + i] = arr2[i];
        }

        return result;
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(n)
*/