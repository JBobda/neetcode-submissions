class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();

        for(int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int current = -1;

        for(int key : freq.keySet()) {
            if(key == freq.get(key) && key > current) {
                current = key;
            }
        }

        return current;
    }
}