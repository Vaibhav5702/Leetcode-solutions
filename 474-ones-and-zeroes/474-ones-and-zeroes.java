class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp=new int[m+1][n+1];
        for(String s:strs)
        {
            int[] count=getCount(s);
            for(int i=m;i>=count[0];i--)
            {
                for(int j=n;j>=count[1];j--)
                {
                    dp[i][j]=Math.max(dp[i-count[0]][j-count[1]]+1,dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }
    public int[] getCount(String s)
    {
        int[] count=new int[2];
        for(char ch:s.toCharArray())
        {
            count[ch-'0']++;
        }
        return count;
    }
}