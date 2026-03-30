class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();

        int ROWS = heights.length;
        int COLS = heights[0].length;

        HashSet<List<Integer>> pacific = new HashSet<>();
        HashSet<List<Integer>> atlantic = new HashSet<>();

        for(int r = 0; r < ROWS; r++) {
            //Pacific
            dfs(heights, pacific , r, 0);
            //Atlantic
            dfs(heights, atlantic, r, COLS - 1);
        }

        for(int c = 0; c < COLS; c++) {
            // Pacific
            dfs(heights, pacific, 0, c);

            // Atlantic
            dfs(heights, atlantic, ROWS - 1, c);
        }

        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                List<Integer> current = Arrays.asList(r, c);
                if(pacific.contains(current) && atlantic.contains(current)){
                    result.add(current);
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, HashSet<List<Integer>> visited, int r, int c) {
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        List<Integer> current = Arrays.asList(r, c);
        if(visited.contains(current)){
            return;
        }
        visited.add(current);

        for(int[] dir : dirs) {
            List<Integer> updated = Arrays.asList(r + dir[0], c + dir[1]);
            int newR = updated.get(0);
            int newC = updated.get(1);

            if(newR >= 0 && newC >= 0 && newR < heights.length && newC < heights[0].length && heights[newR][newC] >= heights[r][c]) {
                dfs(heights, visited, newR, newC);
            }
        }
    }
}
