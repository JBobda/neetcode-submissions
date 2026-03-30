class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(grid[r][c] == Integer.MAX_VALUE)
                    bfs(grid, r, c);
            }
        }
    }

    public void bfs(int[][] grid, int row, int col) {
        HashSet<List<Integer>> visited = new HashSet<>();
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<List<Integer>> coords = new LinkedList<>();
        List<Integer> start = Arrays.asList(row, col);
        coords.add(start);
        visited.add(start);
        int count = 1;

        while(!coords.isEmpty()) {
            int n = coords.size();

            for(int i = 0; i < n; i++) {
                List<Integer> current = coords.poll();

                for(int[] dir : dirs) {
                    List<Integer> updated = Arrays.asList(current.get(0) + dir[0], current.get(1) + dir[1]);
                    int r = updated.get(0);
                    int c = updated.get(1);

                    if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && !visited.contains(updated)) {
                        if(grid[r][c] == 0) {
                            grid[start.get(0)][start.get(1)] = count;
                            return;
                        }
                        if(grid[r][c] != -1) {
                            coords.add(updated);
                            visited.add(updated);
                        }
                    }
                }
            }
            count++;
        }
    }
}
