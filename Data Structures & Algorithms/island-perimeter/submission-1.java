class Solution {
    public int islandPerimeter(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        Set<List<Integer>> visited = new HashSet<>();
        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(grid[r][c] == 1) {
                    return bfs(grid, visited, r, c);
                }
            }
        }

        return 0;
    }

    public int bfs(int[][] grid, Set<List<Integer>> visited, int row, int col) {
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(Arrays.asList(row, col));
        visited.add(Arrays.asList(row, col));
        int total = 0;
        while(!queue.isEmpty()) {
            int n = queue.size();
            int counter = 4 * n;
            for(int i = 0; i < n; i++) {
                List<Integer> coord = queue.poll();
                int r = coord.get(0);
                int c = coord.get(1);
                for(int[] dir : directions) {
                    int dr = r + dir[0];
                    int dc = c + dir[1];
                    List<Integer> updated = Arrays.asList(dr, dc);

                    if(!visited.contains(updated) && dr >= 0 && dc >= 0 && dr < grid.length && dc < grid[0].length && grid[dr][dc] == 1) {
                        queue.add(updated);
                        visited.add(updated);
                        counter--;
                    } else if(visited.contains(updated)) {
                        counter--;
                    }
                }
            }
            total += counter;
            System.out.println(total + " " + queue);
        }

        return total;
    }
}




