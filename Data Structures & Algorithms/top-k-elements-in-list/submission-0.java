class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> buckets = new ArrayList<List<Integer>>();

        // Initialize the buckets
        for(int i = 0; i < nums.length + 1; i++) {
            buckets.add(new ArrayList<Integer>());
        }

        // Iterate through nums and count frequencies with HashMap
        for(int num : nums) {
            if(map.getOrDefault(num, 0) == 0) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        // Iterate through HashMap and add values to the buckets
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            buckets.get(entry.getValue()).add(entry.getKey());
        }

        // Iterate back -> front k times to get the top k values
        int[] answer = new int[k];
        int index = 0;
        for(int i = buckets.size() - 1; i >= 0; i--) {
            if(buckets.get(i).size() > 0) {
                // If a bucket is non empty, then iterate through and add all elements to answer until k is satisfied
                for(int j = 0; j < buckets.get(i).size() && index < k; j++) {
                    answer[index] = buckets.get(i).get(j);
                    index++;
                }
            }
        }

        return answer;
    }
}
