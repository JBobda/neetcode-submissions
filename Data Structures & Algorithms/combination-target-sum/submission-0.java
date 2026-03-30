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
            results.add(current);
            seen.add(current);
            return;
        }

        // Choosing to not add the current number
        backtracking(nums, index + 1, target, current, results, seen);

        // Choosing to add the current number and go to the next
        List<Integer> currentCopy = new ArrayList<>(current);
        currentCopy.add(nums[index]);
        backtracking(nums, index + 1, target - nums[index], currentCopy, results, seen);

        // Choosing to add the current number and not increment
        List<Integer> currentCopyStay = new ArrayList<>(currentCopy);
        backtracking(nums, index, target - nums[index], currentCopyStay, results, seen);
    }
}
