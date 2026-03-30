class Solution {
    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> memo = new HashMap<>();
        int total = dp(coins, amount, memo);
        return total == Integer.MAX_VALUE ? -1 : total;
    }

    private int dp(int[] coins, int amount, Map<Integer, Integer> memo) {
        if(memo.containsKey(amount)) {
            return memo.get(amount);
        }
        if(amount < 0) {
            return Integer.MAX_VALUE;
        }

        if(amount == 0) {
            return 0;
        }

        int result = Integer.MAX_VALUE;

        for(int coin : coins) {
            int hold = dp(coins, amount - coin, memo);
            if(hold != Integer.MAX_VALUE)
                result = Math.min(result, hold + 1);
        }

        memo.put(amount, result);

        return result;
    }
}
