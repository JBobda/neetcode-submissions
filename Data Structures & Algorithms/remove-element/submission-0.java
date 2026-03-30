class Solution {
    public int removeElement(int[] nums, int val) {
        int counter = 0;

        int track = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[track] = nums[i];
                track++;
                counter++;
            }
        }

        return counter;
    }
}