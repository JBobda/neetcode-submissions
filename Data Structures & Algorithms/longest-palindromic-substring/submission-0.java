class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        for(int i = 0; i < s.length(); i++) {
            // Odd length
            int left = i;
            int right = i;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                int subLength = right - left + 1;
                if(subLength > result.length()) {
                    result = s.substring(left, right + 1);
                }
                left--;
                right++;
            }

            // Even length
            left = i;
            right = i + 1;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                int subLength = right - left + 1;
                if(subLength > result.length()) {
                    result = s.substring(left, right + 1);
                }
                left--;
                right++;
            }
        }

        return result;
    }
}
