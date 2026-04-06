class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        backTracking(nums, new ArrayList<>(), 0, result);

        return result;
    }

    private void backTracking(int[] nums, List<Integer> current, int index, List<List<Integer>> result) {
        if(index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Choose to include the current one
        current.add(nums[index]);
        backTracking(nums, current, index + 1, result);
        current.removeLast();

        // Choose to skip the current one and it's duplicates
        while(index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }

        backTracking(nums, current, index + 1, result);
    }
}
