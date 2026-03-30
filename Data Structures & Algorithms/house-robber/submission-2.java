class Solution {
    public int rob(int[] nums) {
        Map<Integer, Integer> memo = new HashMap<>();
        return Math.max(dp(nums, 0, memo), dp(nums, 1, memo));
    }

    private int dp(int[] nums, int i, Map<Integer, Integer> memo) {
        if(memo.containsKey(i)) {
            return memo.get(i);
        }
        if(i >= nums.length) {
            return 0;
        }

        if(i == nums.length) {
            return nums[i];
        }

        int hold = 0;
        for(int idx = 2; idx < nums.length - i; idx++) {
            hold = Math.max(hold, dp(nums, i + idx, memo));
        }
        int result = nums[i] + hold;
        memo.put(i, result);
        return result;
    }
}
