class Solution {
    public int lengthOfLongestSubstring(String s) {
        String max = "";

        int index = 0;
        while(index < s.length()) {
            Map<Character, Integer> map = new HashMap<>();

            String current = "";
            for(int i = index; i < s.length(); i++) {
                char c = s.charAt(i);
                if(map.getOrDefault(c, 0) != 0) {
                    break;
                }
                current += c;
                if(max.length() < current.length())
                    max = current;
                map.put(c, 1);

            }
            index++;
        }

        return max.length();
    }
}
