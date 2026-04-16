class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        dp(s, 0, new ArrayList<>(), result);

        return result;
    }

    private void dp(String s, int index, List<String> current, List<List<String>> result) {
        if(index == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = index; i < s.length(); i++) {
            String sub = s.substring(index, i + 1);

            if(isPalindrome(sub)) {
                current.add(sub);
                dp(s, i + 1, current, result);
                current.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s) {
        for(int i = 0; i < s.length() / 2; i++) {
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }

        return true;
    }
}
