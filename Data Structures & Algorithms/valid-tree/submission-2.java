class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> adList = new HashMap<>();

        for(int[] edge : edges) {
            List<Integer> list = adList.get(edge[0]);
            List<Integer> rList = adList.get(edge[1]);

            if(list == null) {
                list = new ArrayList<>();
                list.add(edge[1]);
                adList.put(edge[0], list);
            } else {
                list.add(edge[1]);
            }

            if(rList == null) {
                rList = new ArrayList<>();
                rList.add(edge[0]);
                adList.put(edge[1], rList);
            } else {
                rList.add(edge[0]);
            }
        }

        Set<Integer> visited = new HashSet<>();

        boolean cycleFree = dfs(adList, visited, 0, -1);

        if(!cycleFree)
            return false;

        // Check if all nodes were reached by checking size of visited set to number of nodes n
        return visited.size() == n;
    }

    private boolean dfs(Map<Integer, List<Integer>> adList, Set<Integer> visited, int node, int prev) {
        if(visited.contains(node))
            return false;

        visited.add(node);

        List<Integer> connections = adList.get(node);
        if(connections == null) return true;
        boolean result = true;
        for(int connection : connections) {
            if(connection == prev) {
                continue;
            }
            result = result && dfs(adList, visited, connection, node);
        }

        return result;
    }
}
