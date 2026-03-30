class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            int frequency = map.getOrDefault(num, 0);
            if(frequency == 0)
                map.put(num, 1);
            else
                map.put(num, map.get(num) + 1);
        }

        List<Integer> longest = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        for(int num : nums) {
            int frequency = map.getOrDefault(num + 1, 0);
            int index = 0;
            while(frequency > 0){
                current.add(num);
                index++;
                frequency = map.getOrDefault(num + 1 + index, 0);
            }

            current.add(num + index);
            if(current.size() > longest.size()) {
                longest = new ArrayList<>(current);
            }
            current.clear();
            index = 0;
        }

        return longest.size();
    }
}
