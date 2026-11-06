import java.util.Arrays;

class Solution {

    public int[] countServers(int n, int[][] logs, int x, int[] queries) {

        // Sort logs based on request time
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        // Store queries along with their original indices
        int[][] sortedQueries = new int[queries.length][2];

        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        // Sort queries based on query time
        Arrays.sort(sortedQueries,
                (a, b) -> Integer.compare(a[0], b[0]));

        int[] answer = new int[queries.length];

        // Frequency of requests for each server in the current window
        int[] count = new int[n + 1];

        int left = 0;
        int right = 0;
        int activeServers = 0;

        for (int[] query : sortedQueries) {

            int currentTime = query[0];
            int originalIndex = query[1];

            // Add logs within the upper boundary of the window
            while (right < logs.length &&
                    logs[right][1] <= currentTime) {

                int serverId = logs[right][0];

                if (count[serverId] == 0) {
                    activeServers++;
                }

                count[serverId]++;
                right++;
            }

            // Remove logs outside the lower boundary
            while (left < right &&
                    logs[left][1] < currentTime - x) {

                int serverId = logs[left][0];

                count[serverId]--;

                if (count[serverId] == 0) {
                    activeServers--;
                }

                left++;
            }

            // Servers with no requests in the current window
            answer[originalIndex] = n - activeServers;
        }

        return answer;
    }
}