class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Integer> timeMap = new HashMap<>();
        
        // Initialize timeMap with infinity, except for start node
        for (int i = 1; i <= n; i++){
            timeMap.put(i, Integer.MAX_VALUE);
        }
        timeMap.put(k, 0);

        dfs(times, n, k, 0, timeMap);

        int max = 0;
        for(int i = 1; i <= n; i++) {
            if (timeMap.get(i) == Integer.MAX_VALUE) return -1;
            max = Math.max(timeMap.get(i), max);
        }

        return max;
    }

    public int dfs(int[][] times, int n, int k, int currentSum, Map<Integer, Integer> timeMap) {
        for(int i = 0; i < times.length; i++) {
            if(times[i][0] == k) {
                int nextNode = times[i][1];
                int weight = times[i][2];
                // Only proceed if we found a shorter path to the next node
                if(currentSum + weight < timeMap.get(nextNode)) {
                    timeMap.put(nextNode, currentSum + weight);
                    dfs(times, n, nextNode, currentSum + weight, timeMap);
                }
            }
        }

        return 0;
    }
}