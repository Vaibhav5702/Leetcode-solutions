class Solution {
    public int scoreOfParentheses(String s) {
        int len=0,score=0;
        for(int i=1;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='(')
                len++;
            else if(s.charAt(i-1)=='(')
            {
                score+=(int)Math.pow(2,len);
                len--;
            }
            else
            {
                len--;
            }
        }
        return score;
    }
}