class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        backTracking(nums, new ArrayList<>(), 0, result);

        return result;
    }

    private void backTracking(int[] nums, List<Integer> current, int index, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));

        for(int i = index; i < nums.length; i++) {
            if(i > index && nums[i] == nums[i - 1]) continue;

            current.add(nums[i]);

            backTracking(nums, current, i + 1, result);

            current.removeLast();
        }
    }
}
