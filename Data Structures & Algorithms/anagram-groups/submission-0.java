class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String string : strs) {
            char[] arr = string.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);

            if(map.get(sorted) != null) {
                map.get(sorted).add(string);
                map.put(sorted, map.get(sorted));
            } else {
                List<String> list = new ArrayList<>();
                list.add(string);
                map.put(sorted, list);
            }
        }

        List<List<String>> answer = new ArrayList<List<String>>();
        for(String string : strs) {
            char[] arr = string.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);

            if(map.get(sorted) != null) {
                answer.add(map.get(sorted));
                map.put(sorted, null);
            }
        }

        return answer;
        
    }
}
