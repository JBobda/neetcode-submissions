class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        recursion(nums, 0, new ArrayList<>(), result);

        return result;
    }

    private void recursion(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        if(index >= nums.length) {
            result.add(current);
            return;
        }

        recursion(nums, index + 1, new ArrayList<>(current), result);

        List<Integer> newCurrent = new ArrayList<>(current);
        newCurrent.add(nums[index]);
        recursion(nums, index + 1, newCurrent, result);
    }
}
