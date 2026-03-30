class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adList = new HashMap<>();

        for(int i = 0; i < numCourses; i++) {
            adList.put(i, new ArrayList<>());
        }

        for(int[] pre : prerequisites) {
            List<Integer> list = adList.get(pre[0]);
            list.add(pre[1]);
        }

        Set<Integer> cycle = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        for(int i = 0; i < numCourses; i++) {
            if(!dfs(adList, visited, cycle, i)) {
                return false;
            }
        }

        return true;
    }

    public boolean dfs(Map<Integer, List<Integer>> adList, Set<Integer> visited, Set<Integer> cycle, int node) {
        if(cycle.contains(node)) {
            return false;
        }

        if(visited.contains(node)) {
            return true;
        }

        cycle.add(node);
        List<Integer> pres = adList.get(node);
        for(int pre : pres) {
            if(!dfs(adList, visited, cycle, pre)) {
                return false;
            }
        }
        cycle.remove(node);
        visited.add(node);

        return true;
    }
}
