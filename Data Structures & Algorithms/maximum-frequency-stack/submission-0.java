class FreqStack {

    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> group;
    int maxFreq;

    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        maxFreq = 0;
        
    }
    
    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);

        maxFreq = Math.max(maxFreq, f);
        group.putIfAbsent(f, new Stack<>());
        group.get(f).push(val);
    }
    
    public int pop() {
        Stack<Integer> stack = group.get(maxFreq);
        int val = stack.pop();

        freq.put(val, freq.get(val) - 1);

        if(stack.isEmpty()){
            maxFreq--;
        }
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */