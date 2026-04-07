class Solution {
    private Boolean[][] memo;

    public boolean isSubsequence(String s, String t) {
        memo = new Boolean[s.length()][t.length()];

        return dp(s, t, 0, 0);
    }

    private boolean dp(String s, String t, int i, int j) {
        if(i == s.length()) {
            return true;
        }

        if(j == t.length()) {
            return false;
        }

        if(memo[i][j] != null) {
            return memo[i][j];
        }

        boolean result = dp(s, t, i, j + 1);

        if(s.charAt(i) == t.charAt(j)) {
            result = result || dp(s, t, i + 1, j + 1);
        }

        memo[i][j] = result;

        return result;
    }
}