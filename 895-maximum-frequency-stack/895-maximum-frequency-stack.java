class FreqStack {

    Map<Integer,Integer> freq;
    Map<Integer,Stack<Integer>> map;
    int maxFreq;
    public FreqStack() {
        freq=new HashMap();
        map=new HashMap();
        maxFreq=0;
    }
    
    public void push(int val) {
        int frequency=freq.getOrDefault(val,0)+1;
        freq.put(val,frequency);
        if(map.containsKey(frequency))
            map.get(frequency).push(val);
        else
        {
            maxFreq=frequency;
            Stack<Integer> stack=new Stack();
            stack.push(val);
            map.put(frequency,stack);
        }
    }
    
    public int pop() {
        Stack<Integer> stack=map.get(maxFreq);
        if(stack.size()==1)
        {
            map.remove(maxFreq);
            maxFreq--;
            
        }
        freq.put(stack.peek(),freq.get(stack.peek())-1);
        return stack.pop();
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */