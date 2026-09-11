import java.util.Arrays;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        int n = intervals.length;

        // Sort intervals based on starting time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Store merged intervals
        int[][] ans = new int[n][2];
        int ind = 0;

        // Add the first interval
        ans[ind][0] = intervals[0][0];
        ans[ind][1] = intervals[0][1];
        ind++;

        // Merge overlapping intervals
        for (int i = 1; i < n; i++) {

            // If current interval overlaps with the last merged interval
            if (intervals[i][0] <= ans[ind - 1][1]) {

                ans[ind - 1][1] =
                    Math.max(ans[ind - 1][1], intervals[i][1]);

            } else {

                // No overlap, add current interval
                ans[ind][0] = intervals[i][0];
                ans[ind][1] = intervals[i][1];
                ind++;
            }
        }

        // Return only the filled portion of the array
        return Arrays.copyOf(ans, ind);
    }
}

/*
Time Complexity:
O(n log n) -> Sorting the intervals
O(n)       -> Traversing the intervals
Overall    -> O(n log n)

Space Complexity:
O(n) -> Output array used to store merged intervals
*/
