class Solution {
    private static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int islandCount = 0;

        for(int row = 0; row < ROWS; row++) {
            for(int col = 0; col < COLS; col++) {
                if(grid[row][col] == '1') {
                    dfs(grid, row, col);
                    islandCount++;
                }
            }
        }

        return islandCount;
    }

    private void dfs(char[][] grid, int row, int col) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[row].length || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';
        for(int i = 0; i < directions.length; i++) {
            dfs(grid, row + directions[i][0], col + directions[i][1]);
        }
    }
}
