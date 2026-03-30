class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] answer = new int[2*n];

        for(int i = 0; i < answer.length; i++) {
            answer[i] = nums[(i + n) % n];
        }

        return answer;
    }
}