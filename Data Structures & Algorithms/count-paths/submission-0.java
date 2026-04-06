class Solution {
    private int[][] memo;

    public int uniquePaths(int m, int n) {
        memo = new int[m][n];

        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dp(m, n, 0, 0);
    }

    private int dp(int m, int n, int i, int j) {
        if(memo[i][j] != -1) {
            return memo[i][j];
        }
        if(i == m - 1 && j == n - 1) {
            return 1;
        }

        int total = 0;

        if(i + 1 < m) total += dp(m, n, i + 1, j);

        if(j + 1 < n) total += dp(m, n, i, j + 1);

        memo[i][j] = total;

        return total;
    }
}
