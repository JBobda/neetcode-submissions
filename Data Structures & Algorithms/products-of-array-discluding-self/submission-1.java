class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int product = 1, zeros = 0, index = -1;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                zeros++;
                index = i;
            } else {
                product *= nums[i];
            }
        }

        Arrays.fill(output, 0);

        if(zeros == 0) {
            for(int i = 0; i < nums.length; i++) {
                output[i] = product / nums[i];
            }
        }

        if(zeros == 1) {
            output[index] = product;
        }

        return output;
    }
}  
