class Solution {
    public String minRemoveToMakeValid(String s) {
        int open=0;
        StringBuilder sb=new StringBuilder();
        for(char ch:s.toCharArray())
        {
            if(ch=='(')
            {
                sb.append(ch);
                open++;
            }
            else if(ch==')')
            {
                if(open>0)
                {
                    sb.append(ch);
                    open--;
                }
            }
            else
                sb.append(ch);
        }
        while(open>0)
        {
            sb.deleteCharAt(sb.lastIndexOf("("));
            open--;
        }
        return sb.toString();
    }
}