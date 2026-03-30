class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                prefix[i] = nums[i];
                postfix[nums.length - 1] = nums[nums.length - 1];
            } else {
                prefix[i] = prefix[i - 1] * nums[i];
                postfix[nums.length - 1 - i] = postfix[nums.length - i] * nums[nums.length - 1 - i];
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                output[i] = postfix[i + 1];
            } else if(i == nums.length - 1) {
                output[i] = prefix[i - 1];
            } else {
                output[i] = prefix[i - 1] * postfix[i + 1];
            }
        }

        return output;
    }
}  
