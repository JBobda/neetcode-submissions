class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adList = new HashMap<>();

        for(int i = 0; i < numCourses; i++) {
            adList.put(i, new ArrayList<>());
        }

        for(int[] prereq : prerequisites) {
            List<Integer> coursePres = adList.get(prereq[0]);
            coursePres.add(prereq[1]);
        }

        List<Integer> outputList = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();
        for(int i = 0; i < numCourses; i++) {
            if(!dfs(adList, visited, cycle, i, outputList)) {
                return new int[0];
            }
        }

        int[] output = new int[outputList.size()];
        for(int i = 0; i < outputList.size(); i++) {
            output[i] = outputList.get(i);
        }
        return output;
    }

    public boolean dfs(Map<Integer, List<Integer>> adList, Set<Integer> visited, Set<Integer> cycle, int node, List<Integer> outputList) {
        if(cycle.contains(node)) {
            return false;
        }
        if(visited.contains(node)) {
            return true;
        }

        cycle.add(node);
        List<Integer> pres = adList.get(node);
        for(int pre : pres) {
            if(!dfs(adList, visited, cycle, pre, outputList)) {
                return false;
            }
        }
        cycle.remove(node);
        visited.add(node);
        outputList.add(node);

        return true;
    }
}
