class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> adList = new HashMap<>();

        for(int[] edge : edges) {
            List<Integer> xlist = adList.get(edge[0]);
            List<Integer> ylist = adList.get(edge[1]);

            if(xlist == null) {
                xlist = new ArrayList<>();
                xlist.add(edge[1]);
                adList.put(edge[0], xlist);
            } else {
                xlist.add(edge[1]);
            }

            if(ylist == null) {
                ylist = new ArrayList<>();
                ylist.add(edge[0]);
                adList.put(edge[1], ylist);
            } else {
                ylist.add(edge[0]);
            }
        }

        int counter = 0;
        Set<Integer> visited = new HashSet<>();
        for(int i = 0; i < n; i++) {
            int node = i;

            if(!visited.contains(node)) {
                dfs(adList, visited, node, -1);
                counter++;
            }
        }

        return counter;
    }

    private void dfs(Map<Integer, List<Integer>> adList, Set<Integer> visited, int node, int prev) {
        if(visited.contains(node))
            return;

        visited.add(node);

        List<Integer> connections = adList.get(node);
        if(connections == null) return;

        for(int connection : connections) {
            if(!visited.contains(connection) && connection != prev) {
                dfs(adList, visited, connection, node);
            }
        }
    }
}
