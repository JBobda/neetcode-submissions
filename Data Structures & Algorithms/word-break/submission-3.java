class Solution {
    private Boolean[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);

        memo = new Boolean[s.length()];

        return dp(s, wordSet, 0);
    }

    private boolean dp(String s, Set<String> wordSet, int index) {
        if(index == s.length()) {
            return true;
        }

        if(memo[index] != null) {
            return memo[index];
        }

        boolean result = false;

        for(int i = index; i < s.length(); i++) {
            String substring = s.substring(index, i + 1);

            if(wordSet.contains(substring)) {
                result = result || dp(s, wordSet, i + 1);
            }
        }

        memo[index] = result;

        return result;
    }
}
