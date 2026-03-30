class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            int a = nums[i];
            if(i > 0 && a == nums[i-1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while(left < right) {
                int sum = a + nums[left] + nums[right];
                if(sum > 0) {
                    right--;
                }

                if(sum < 0) {
                    left++;
                }

                if(sum == 0) {
                    result.add(new ArrayList<Integer>(Arrays.asList(a, nums[left], nums[right])));
                    left++;
                    while(nums[left] == nums[left - 1] && left < right) {
                        left++;
                    }
                }
            }
        }

        return result;
    }
}
