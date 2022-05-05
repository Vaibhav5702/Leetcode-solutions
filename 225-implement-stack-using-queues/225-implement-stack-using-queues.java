class MyStack {
    Queue<Integer> q1;
    public MyStack() {
        q1=new LinkedList();
        
    }
    
    public void push(int x) {
        int size=q1.size();
        q1.offer(x);
        for(int i=0;i<size;i++)
        {
            q1.offer(q1.poll());
        }
    }
    
    public int pop() {
        return q1.poll();
    }
    
    public int top() {
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */