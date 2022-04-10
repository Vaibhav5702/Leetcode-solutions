class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack=new Stack();
        for(String op:ops)
        {
            char k=op.charAt(0);
            if(k=='+')
            {
                int a=stack.pop();
                int b=stack.peek();
                stack.push(a);
                stack.push(a+b);
            }
            else if(k=='D')
            {
                stack.push(2*stack.peek());
            }
            else if(k=='C')
            {
                stack.pop();
            }
            else
            {
                stack.push(Integer.parseInt(op));
            }
        }
        int sum=0;
        while(!stack.isEmpty())
        {
            sum+=stack.pop();
        }
        return sum;
    }
}