class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int left = 0;
        int right = left + 1;

        while(right < nums.length) {
            if(nums[left] == nums[right]) {
                return true;
            }

            if(right - left >= k && left + 1 != right) {
                left++;
            } else if(right + 1 - left <= k){
                right++;
            } else {
                left++;
                right++;
            }
        }

        return false;
    }
}