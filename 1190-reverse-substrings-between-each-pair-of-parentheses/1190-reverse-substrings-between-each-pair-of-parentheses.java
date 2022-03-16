class Solution {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> stack=new Stack();
        s="("+s;
        for(char c:s.toCharArray())
        {
            if(c=='(')
            {
                stack.push(new StringBuilder());
            }
            else if(c==')')
            {
                StringBuilder sb=stack.pop();
                stack.peek().append(sb.reverse().toString());
            }
            else
            {
                stack.peek().append(c);
            }
        }
        return stack.peek().toString();
    }
}