class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backTracking(nums, new ArrayList<>(), result);

        return result;
    }

    private void backTracking(int[] nums, List<Integer> current, List<List<Integer>> result) {
        if(current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(current.contains(nums[i])) continue;

            current.add(nums[i]);

            backTracking(nums, current, result);

            current.removeLast();
        }
    }
}
