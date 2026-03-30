class Solution {
    public void solve(char[][] board) {
        int ROWS = board.length;
        int COLS = board[0].length;

        // Capture unsurrounded regions
        for(int r = 0; r < ROWS; r++) {
            if(board[r][0] == 'O') {
                dfs(board, r, 0);
            }

            if(board[r][COLS -1] == 'O') {
                dfs(board, r, COLS - 1);
            }
        }

        for(int c = 0; c < COLS; c++) {
            if(board[0][c] == 'O') {
                dfs(board, 0, c);
            }

            if(board[ROWS - 1][c] == 'O') {
                dfs(board, ROWS - 1, c);
            }
        }
        // Capture surrounded regions

        // Uncapture unsurrounded regions\
        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if(board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != 'O') {
            return;
        }

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        board[row][col] = 'T';

        for(int[] dir : dirs) {
            int r = row + dir[0];
            int c = col + dir[1];
            dfs(board, r, c);
        }
    }
}
