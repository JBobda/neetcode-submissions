class Solution {
    private int[][] memo;

    public int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()][text2.length()];

        for(int[] row : memo) Arrays.fill(row, -1);

        return dp(text1, text2, 0, 0);
    }

    private int dp(String text1, String text2, int idx1, int idx2) {
        if(idx1 == text1.length() || idx2 == text2.length()) {
            return 0;
        }

        if(memo[idx1][idx2] != -1) {
            return memo[idx1][idx2];
        }

        int max = 0;

        if(text1.charAt(idx1) == text2.charAt(idx2)) {
            max = Math.max(max, 1 + dp(text1, text2, idx1 + 1, idx2 + 1));
        }

        max = Math.max(max, dp(text1, text2, idx1, idx2 + 1));
        max = Math.max(max, dp(text1, text2, idx1 + 1, idx2));

        memo[idx1][idx2] = max;

        return max;
    }
}
