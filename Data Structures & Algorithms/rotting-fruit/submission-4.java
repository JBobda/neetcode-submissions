class Solution {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        Queue<List<Integer>> coords = new LinkedList<>();
        int fresh = 0;

        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(grid[r][c] == 2) {
                    coords.add(Arrays.asList(r, c));
                }

                if(grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        return bfs(grid, coords, fresh);
    }

    private int bfs(int[][] grid, Queue<List<Integer>> coords, int fresh) {
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int minute = 0;

        while(!coords.isEmpty() && fresh > 0) {
            int n = coords.size();

            for(int i = 0; i < n; i++) {
                List<Integer> current = coords.poll();

                if(grid[current.get(0)][current.get(1)] == 2) {
                    for(int[] dir : dirs) {
                        int r = current.get(0) + dir[0];
                        int c = current.get(1) + dir[1];

                        if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 1) {
                            grid[r][c] = 2;
                            coords.add(Arrays.asList(r, c));
                            fresh--;
                        }
                    }
                }
            }
            minute++;
        }

        return fresh == 0 ? minute : -1;
    }
}
