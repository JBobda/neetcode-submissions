class KthLargest {
    private int k;
    private PriorityQueue<Integer> nums;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = new PriorityQueue<>((a, b) -> b - a );

        for(int num : nums) {
            this.nums.add(num);
        }
    }
    
    public int add(int val) {
        this.nums.add(val);
        
        List<Integer> holding = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            holding.add(nums.poll());
        }

        int result = holding.get(holding.size() - 1);

        for(int element : holding) {
            nums.add(element);
        }

        return result;
    }
}
