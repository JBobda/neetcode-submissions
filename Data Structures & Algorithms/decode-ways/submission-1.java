class Solution {
    public int numDecodings(String s) {
        Map<Integer, Integer> memo = new HashMap<>();
        return dp(s, 0, memo);
    }

    private int dp(String s, int index, Map<Integer, Integer> memo) {
        if(memo.containsKey(index)) {
            return memo.get(index);
        }
        if(index == s.length()) {
            return 1;
        }

        if(s.charAt(index) == '0') {
            return 0;
        }

        int count = dp(s, index + 1, memo);

        if(index + 1 < s.length()) {
            int num = Integer.parseInt(s.substring(index, index + 2));
            if(num <= 26) {
                count += dp(s, index + 2, memo);
            }
        }

        memo.put(index, count);

        return count;
    }
}
