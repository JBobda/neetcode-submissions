class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Set<List<Integer>> seen = new HashSet<>();
        List<List<Integer>> results = new ArrayList<>();

        backtracking(nums, 0, target, new ArrayList<>(), results, seen);

        return results;
    }

    private void backtracking(int[] nums, int index, int target, List<Integer> current, List<List<Integer>> results, Set<List<Integer>> seen) {
        if(seen.contains(current)) {
            return;
        }
        if(index >= nums.length) {
            return;
        }

        if(target < 0) {
            return;
        }

        if(target == 0) {
            results.add(new ArrayList<>(current));
            seen.add(new ArrayList<>(current));
            return;
        }

        // Choosing to not add the current number
        backtracking(nums, index + 1, target, current, results, seen);

        // Choosing to add the current number and not increment
        current.add(nums[index]);
        backtracking(nums, index, target - nums[index], current, results, seen);
        current.remove(current.size() - 1);

    }
}
