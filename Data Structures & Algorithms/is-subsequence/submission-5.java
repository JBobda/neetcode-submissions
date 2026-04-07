class Solution {
    public boolean isSubsequence(String s, String t) {
        return dp(s, t, 0, 0);
    }

    private boolean dp(String s, String t, int i, int j) {
        if(i == s.length()) {
            return true;
        }

        if(j == t.length()) {
            return false;
        }

        boolean result = dp(s, t, i, j + 1);

        if(s.charAt(i) == t.charAt(j)) {
            result = result || dp(s, t, i + 1, j + 1);
        }

        return result;
    }
}