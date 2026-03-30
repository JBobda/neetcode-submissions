class Solution {
    public int tribonacci(int n) {
        Map<Integer, Integer> memo = new HashMap<>();

        return dp(n, memo);
    }

    private int dp(int n, Map<Integer, Integer> memo) {
        if(memo.containsKey(n)) {
            return memo.get(n);
        }
        if(n == 0) {
            return 0;
        }

        if(n == 1 || n == 2) {
            return 1;
        }

        memo.put(n, dp(n - 1, memo) + dp(n - 2, memo) + dp(n - 3, memo));

        return memo.get(n);
    }
}