public class RotateImage {
    /*
     * Approach:
     * Create a new matrix and place each element at its
     * correct position for a 90-degree clockwise rotation.
     *
     * Formula:
     * ans[j][n - 1 - i] = matrix[i][j]
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(n^2)
     */

    public void rotate(int[][] matrix) {

        int n = matrix.length;

        int[][] ans = new int[n][n];

        // Rotate the matrix by 90 degrees clockwise
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                ans[j][n - 1 - i] = matrix[i][j];
            }
        }

        // Copy the rotated matrix back to the original matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                matrix[i][j] = ans[i][j];
            }
        }
    }
}
