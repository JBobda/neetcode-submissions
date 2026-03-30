class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length < 2){
            return stones[0];
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        for(int stone : stones) {
            maxHeap.add(stone);
        }

        while(maxHeap.size() > 1) {
            int x = maxHeap.poll();
            int y = maxHeap.poll();

            int result = x - y;

            if(result > 0)
                maxHeap.add(result);
        }

        if(maxHeap.size() == 0)
            return 0;

        return maxHeap.poll();
    }
}
