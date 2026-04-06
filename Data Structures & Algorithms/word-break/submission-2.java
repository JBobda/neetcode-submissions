class Solution {
    private Map<String, Boolean> memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);

        memo = new HashMap<>();

        return dp(s, wordSet);
    }

    private boolean dp(String s, Set<String> wordSet) {
        if(memo.containsKey(s)) {
            return memo.get(s);
        }
        if(s.equals("")) {
            return true;
        }

        boolean result = false;

        for(int i = 0; i < s.length(); i++) {
            String substring = s.substring(0, i + 1);

            if(wordSet.contains(substring)) {
                result = result || dp(s.substring(i + 1), wordSet);
            }
        }

        memo.put(s, result);

        return result;
    }
}
