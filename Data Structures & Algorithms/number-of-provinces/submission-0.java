class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        Map<Integer, List<Integer>> adList = new HashMap<>();

        for(int i = 1; i <= n; i++) {
            adList.put(i, new ArrayList<>());
        }

        for(int r = 0; r < n; r++) {
            for(int c = 0; c < n; c++) {
                if(isConnected[r][c] == 1 && r != c) {
                    List<Integer> connections = adList.get(r + 1);

                    connections.add(c + 1);
                }
            }
        }

        Set<Integer> visited = new HashSet<>();
        int total = 0;
        for(int i = 1; i <= n; i++) {
            if(!visited.contains(i)) {
                dfs(i, adList, visited);
                total++;
            }
        }

        return total;
    }

    private void dfs(int i, Map<Integer, List<Integer>> adList, Set<Integer> visited) {
        if(visited.contains(i)) {
            return;
        }

        visited.add(i);

        List<Integer> connections = adList.get(i);

        for(int connection : connections) {
            dfs(connection, adList, visited);
        }
    }
}