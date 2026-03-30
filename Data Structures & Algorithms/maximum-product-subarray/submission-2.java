class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];

        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            int current = nums[i];
            for(int j = i + 1; j < nums.length; j++) {
                current *= nums[j];
                max = Math.max(max, current);
            }
        }

        return max;
    }

}
