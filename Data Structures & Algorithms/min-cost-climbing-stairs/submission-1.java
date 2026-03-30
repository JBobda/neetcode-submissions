class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int top = cost.length;
        Map<Integer, Integer> memo = new HashMap<>();
        return Math.min(dp(cost, 0, top, memo), dp(cost, 1, top, memo));
    }

    private int dp(int[] cost, int start, int top, Map<Integer, Integer> memo) {
        int acc_cost = memo.getOrDefault(start, -1);
        if(acc_cost > 0) {
            return acc_cost;
        }
        if(start >= top) {
            return 0;
        }

        int c = cost[start];

        int curr_cost = c + Math.min(dp(cost, start + 1, top, memo), dp(cost, start + 2, top, memo));
        memo.put(start, curr_cost);

        return curr_cost;
    }
}
