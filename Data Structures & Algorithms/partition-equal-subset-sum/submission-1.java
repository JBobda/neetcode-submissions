class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if(sum % 2 != 0) return false;

        Boolean[][] memo = new Boolean[nums.length][(sum/2) + 1];

        return dp(nums, 0, sum/2, memo);
    }

    private boolean dp(int[] nums, int i, int target, Boolean[][] memo) {
        if(i >= nums.length || target < 0) {
            return false;
        }

        if(target == 0) {
            return true;
        }

        if(memo[i][target] != null) {
            return memo[i][target];
        }

        memo[i][target] = dp(nums, i + 1, target - nums[i], memo) || dp(nums, i + 1, target, memo);
        return memo[i][target];
    }
}
