class Solution {
    public int lengthOfLongestSubstring(String s) {
        String max = "";

        int left = 0;

        HashSet<Character> set = new HashSet<>();
        String current = "";
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            current = s.substring(left, right + 1);
            if(current.length() > max.length())
                max = current;
            
            set.add(s.charAt(right));
        }

        return max.length();
    }
}
