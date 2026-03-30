class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            if(map.getOrDefault(num, 0) == 0) {
                map.put(num, 1);
            } else {
                return true;
            }
        }

        return false;
    }
}