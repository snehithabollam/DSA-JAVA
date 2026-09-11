public class SetMatrixZeores {
    /*
     * Approach:
     * 1. Store which rows and columns contain zero.
     * 2. Traverse the matrix again.
     * 3. Set matrix[i][j] = 0 if its row or column contains a zero.
     *
     * Time Complexity: O(n * m)
     * Space Complexity: O(n + m)
     *
     * n = number of rows
     * m = number of columns
     */

    public void setZeroes(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        int[] row = new int[n];
        int[] col = new int[m];

        // Find all rows and columns that contain zero
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        // Set the corresponding rows and columns to zero
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
