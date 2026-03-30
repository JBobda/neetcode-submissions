class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        if(s.length() != t.length())
            return false;
        
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(char c : t.toCharArray()) {
            int current = map.getOrDefault(c, 0);
            if(current == 0) {
                return false;
            } else if(current > 0) {
                map.put(c, current - 1);
            }
        }

        return true;
    }
}
