class Solution {
    public int longestValidParentheses(String s) {
        int n=s.length();
        int[] dp=new int[n];
        int max=0;
        for(int i=1;i<n;i++)
        {
            char ch=s.charAt(i);
            if(ch=='(')
                continue;
            else if(s.charAt(i-1)=='(')
            {
                if(i-2>=0)
                    dp[i]=dp[i-2]+2;
                else
                    dp[i]=2;
            }
            else
            {
                if(i-dp[i-1]-1>=0&&s.charAt(i-dp[i-1]-1)=='(')
                {
                    if(i-dp[i-1]-2>=0)
                        dp[i]=dp[i-dp[i-1]-2]+dp[i-1]+2;
                    else
                        dp[i]=dp[i-1]+2;
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}