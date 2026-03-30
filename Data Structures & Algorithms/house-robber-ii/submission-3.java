class Solution {
    public int rob(int[] nums) {
        Map<String, Integer> memo = new HashMap<>();
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, dp(nums, i, i, memo));
        }

        return max;
    }

    private int dp(int[] nums, int i, int og, Map<String, Integer> memo) {
        String key = i + ":" + og;
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        if(nums.length == 1) {
            return nums[i];
        }
        if(i >= nums.length) {
            return 0;
        }

        if(i == nums.length - 1 && og == 0) {
            return 0;
        }

        int max = 0;
        for(int j = i + 2; j < nums.length; j++) {
            max = Math.max(max, dp(nums, j, og, memo));
        }

        int result = nums[i] + max;
        memo.put(key, result);

        return result;
    }
}
