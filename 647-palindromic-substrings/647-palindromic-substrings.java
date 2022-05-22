class Solution {
    public int countSubstrings(String s) {
        int n=s.length(),count=0;
        boolean[][] dp=new boolean[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0,k=i;k<n;j++,k++)
            {
                if(i==0)
                {
                    dp[j][k]=true;
                }
                else if(i==1)
                {
                    dp[j][k]=s.charAt(j)==s.charAt(k);
                }
                else
                {
                    dp[j][k]=s.charAt(j)==s.charAt(k)&&dp[j+1][k-1];
                }
                if(dp[j][k])
                    count++;
            }
        }
        return count;
    }
}