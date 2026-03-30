class Solution {
    public int change(int amount, int[] coins) {
        Map<String, Integer> memo = new HashMap<String, Integer>();
        return recursion(coins, 0, amount, memo);
    }

    public int recursion(int[] coins, int i , int amount, Map<String, Integer> memo) {
        if(amount == 0) {
            return 1;
        }

        if(amount < 0) {
            return 0;
        }

        if(i >= coins.length) {
            return 0;
        }

        String key = amount + " : " + i;
        if(memo.containsKey(key)) {
            return memo.get(key);
        }

        // Skip the index
        int x = recursion(coins, i + 1, amount, memo);
        // Subtract from the amount
        int y = recursion(coins, i, amount - coins[i], memo);

        int total = x + y;
        memo.put(key, total);

        return total;
    }
}
