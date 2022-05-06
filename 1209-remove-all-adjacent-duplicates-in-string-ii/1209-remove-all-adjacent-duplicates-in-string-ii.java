class Solution {
    class Pair
    {
        char c;
        int val;
        Pair(char c,int val)
        {
            this.c=c;
            this.val=val;
        }
    }
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack=new Stack();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(!stack.isEmpty()&&ch==stack.peek().c)
            {
                stack.peek().val++;
            }
            else
            {
                stack.push(new Pair(ch,1));
            }
            if(stack.peek().val==k)
                stack.pop();
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty())
        {
            Pair p=stack.pop();
            for(int i=0;i<p.val;i++)
            {
                sb.append(p.c);
            }
        }
        return sb.reverse().toString();
    }
}