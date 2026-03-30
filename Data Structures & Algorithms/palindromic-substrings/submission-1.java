class Solution {
    public int countSubstrings(String s) {
        int total = 0;

        for(int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;
            // Odd size substrings
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                total++;
                left--;
                right++;
            }

            // Even size substrings
            left = i;
            right = i + 1;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                total++;
                left--;
                right++;
            }
        }

        return total;
    }

    private boolean isPalindrome(String s) {
        for(int i = 0; i < s.length()/2; i++) {
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
