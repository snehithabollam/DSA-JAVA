class Regions {
    private void dfs(int row, int col, int[][] visit, char[][] board, int[] delrow, int[] delcol) {
        int n = board.length;
        int m = board[0].length;
        visit[row][col] = 1;
        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visit[nrow][ncol] == 0 && board[nrow][ncol] == 'O') {
                dfs(nrow, ncol, visit, board, delrow, delcol);
            }
        }
    }

    public void Region(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] visit = new int[n][m];
        int[] delrow = { -1, 0, 1, 0 };
        int[] delcol = { 0, 1, 0, -1 };
        for (int j = 0; j < m; j++) {
            if (visit[0][j] == 0 && board[0][j] == 'O') {
                dfs(0, j, visit, board, delrow, delcol);
            }
            if (visit[n - 1][j] == 0 && board[n - 1][j] == 'O') {
                dfs(n - 1, j, visit, board, delrow, delcol);
            }
        }
        for (int i = 0; i < n; i++) {
            if (visit[i][0] == 0 && board[i][0] == 'O') {
                dfs(i, 0, visit, board, delrow, delcol);
            }
            if (visit[i][m - 1] == 0 && board[i][m - 1] == 'O') {
                dfs(i, m - 1, visit, board, delrow, delcol);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visit[i][j] == 0 && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}