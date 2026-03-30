class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>();

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visited.add(beginWord);

        int count = 1;

        while(!queue.isEmpty()) {
            int n = queue.size();

            for(int i = 0; i < n; i++) {
                String current = queue.poll();

                if(current.equals(endWord)) {
                    return count;
                }

                for(String word : wordList) {
                    if(!visited.contains(word) && isOneOff(current, word)) {
                        queue.add(word);
                        visited.add(word);
                    }
                }
            }
            count++;
        }

        return 0;
    }

    public boolean isOneOff(String a, String b) {
        int diffCount = 0;

        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i))
                diffCount++;
        }

        return diffCount <= 1;
    }
}
