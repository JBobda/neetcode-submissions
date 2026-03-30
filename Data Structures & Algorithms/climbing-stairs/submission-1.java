class Solution {
    public int climbStairs(int n) {
        return dp(n, 0, new HashMap<>());
    }

    private int dp(int n, int i, Map<Integer, Integer> memo) {
        if(i == n) {
            return 1;
        }

        if(i > n) {
            return 0;
        }

        int count = memo.getOrDefault(i, 0);
        if(count != 0) {
            return count;
        }

        int result = dp(n, i + 1, memo) + dp(n, i + 2, memo);
        memo.put(i, result);

        return result;
    }
}
