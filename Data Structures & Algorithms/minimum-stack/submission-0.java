class MinStack {

    private ArrayList<Integer> list;
    private int min;

    public MinStack() {
        list = new ArrayList<>();
    }
    
    public void push(int val) {
        list.add(val);
    }
    
    public void pop() {
        list.remove(list.size() - 1);
    }
    
    public int top() {
        return list.get(list.size() - 1);
    }
    
    public int getMin() {
        int min = list.get(0);
        for(Integer num : list) {
            min = Math.min(min, num);
        }

        return min;
    }
}
