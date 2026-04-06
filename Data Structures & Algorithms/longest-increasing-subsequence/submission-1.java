class Solution {
    private int[][] memo;

    public int lengthOfLIS(int[] nums) {
        memo = new int[nums.length][nums.length + 1];

        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dp(nums, 0, -1);
    }

    private int dp(int[] nums, int index, int prev) {
        if(index == nums.length) {
            return 0;
        }

        if(memo[index][prev + 1] != -1) {
            return memo[index][prev + 1];
        }

        int result = dp(nums, index + 1, prev);

        if(prev == -1 || nums[prev] < nums[index]) {
            result = Math.max(result, 1 + dp(nums, index + 1, index));
        }

        memo[index][prev + 1] = result;

        return result;
    }
}
