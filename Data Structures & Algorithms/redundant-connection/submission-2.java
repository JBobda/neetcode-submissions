class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> adList = new HashMap<>();

        for(int i = 1; i <= edges.length; i++) {
            adList.put(i, new ArrayList<>());
        }

        for(int[] edge : edges) {
            List<Integer> list = adList.get(edge[0]);
            List<Integer> list2 = adList.get(edge[1]);

            list.add(edge[1]);
            list2.add(edge[0]);
        }

        for(int i = edges.length - 1; i >= 0; i--) {
            int[] edge = edges[i];

            adList.get(edge[0]).remove(Integer.valueOf(edge[1]));
            adList.get(edge[1]).remove(Integer.valueOf(edge[0]));

            Set<Integer> set = new HashSet<>();
            dfs(adList, set, 1);

            if(set.size() == edges.length)
                return edge;

            adList.get(edge[0]).add(edge[1]);
            adList.get(edge[1]).add(edge[0]);
        }

        return new int[1];
    }

    private void dfs(Map<Integer, List<Integer>> adList, Set<Integer> visited, int node) {
        if(visited.contains(node)) {
            return;
        }

        visited.add(node);

        List<Integer> connections = adList.get(node);
        for(int connection : connections) {
            dfs(adList, visited, connection);
        }
    }
}
