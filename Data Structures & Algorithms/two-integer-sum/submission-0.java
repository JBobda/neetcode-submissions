class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int goal = target - nums[i];
            if(map.get(goal) != null) {
                return new int[]{map.get(goal), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
