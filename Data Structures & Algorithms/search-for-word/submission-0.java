class Solution {
    public boolean exist(char[][] board, String word) {
        int ROWS = board.length;
        int COLS = board[0].length;

        boolean exists = false;
        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                exists = exists || backtracking(board, r, c, word);
            }
        }

        return exists;
    }

    private boolean backtracking(char[][] board, int row, int col, String word) {
        if(word.equals("")) {
            return true;
        }
        
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(0)) {
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '.';
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        boolean hasWord = false;
        for(int[] direction : directions) {
            int updatedRow = row + direction[0];
            int updatedCol = col + direction[1];
            hasWord = hasWord || backtracking(board, updatedRow, updatedCol, word.substring(1));
        }

        board[row][col] = temp;

        return hasWord;
    }
}
