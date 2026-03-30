class Solution {
    public int lengthOfLastWord(String s) {
        String clean = s.strip();

        String[] words = clean.split(" ");

        return words[words.length - 1].length();
    }
}