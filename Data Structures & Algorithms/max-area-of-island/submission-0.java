class Solution {
    private static int counter = 1;
    private static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int max = 0;

        HashSet<List<Integer>> visited = new HashSet<>();
        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                List<Integer> curr = Arrays.asList(r, c);
                if(grid[r][c] == 1 && !visited.contains(curr)) {
                    visited.add(curr);
                    bfs(grid, visited, r, c);
                    max = Math.max(max, counter);
                    counter = 1;
                }
            }
        }

        return max;
    }

    private void bfs(int[][] grid, HashSet<List<Integer>> visited, int row, int col) {
        Queue<List<Integer>> coords = new LinkedList<>();
        List<Integer> start = Arrays.asList(row, col);
        coords.add(start);

        while(!coords.isEmpty()) {
            int n = coords.size();

            for(int i = 0; i < n; i++) {
                List<Integer> current = coords.poll();

                for(int j = 0; j < dirs.length; j++) {
                    List<Integer> updated = Arrays.asList(current.get(0) + dirs[j][0], current.get(1) + dirs[j][1]);
                    int r = updated.get(0);
                    int c = updated.get(1);

                    if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 1 && !visited.contains(updated)) {
                        visited.add(updated);
                        coords.add(updated);
                        counter++;
                    }
                }
            }
        }
    }
}
