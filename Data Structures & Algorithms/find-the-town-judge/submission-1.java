class Solution {
    public int findJudge(int n, int[][] trust) {
        Map<Integer, List<Integer>> adList = new HashMap<>();

        for(int i = 1; i <= n; i++) {
            adList.put(i, new ArrayList<>());
        }

        for(int[] t : trust) {
            List<Integer> trusts = adList.get(t[0]);
            trusts.add(t[1]);
        }

        int possibleTJudge = -1;

        for(int i = 1; i <= n; i++) {
            List<Integer> trusts = adList.get(i);
            if(trusts.size() == 0)
                possibleTJudge = i;
        }

        int indegree = 0;
        for(int i = 1; i <= n; i++) {
            List<Integer> trusts = adList.get(i);
            if(trusts.contains(possibleTJudge)) {
                indegree++;
            }
        }

        return indegree + 1 == n ? possibleTJudge : -1;
    }
}