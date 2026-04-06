class Solution {
    private Map<String, Integer> memo;

    public int findTargetSumWays(int[] nums, int target) {
        memo = new HashMap<>();
        return dp(nums, target, 0, 0);
    }

    private int dp(int[] nums, int target, int index, int sum) {
        String key = index + "," + sum;
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        if(index >= nums.length) {
            return sum == target ? 1 : 0;
        }

        int add = dp(nums, target, index + 1, sum + nums[index]);

        int subtract = dp(nums, target, index + 1, sum - nums[index]);

        int result = add + subtract;

        memo.put(key, result);

        return result;
    }
}
