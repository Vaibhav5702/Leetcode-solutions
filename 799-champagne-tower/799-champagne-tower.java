class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double dp[][]=new double[query_row+1][query_row+2];
        dp[0][0]=poured;
        for(int i=1;i<=query_row;i++)
        {
            for(int j=0;j<=i;j++)
            {
                if(j!=i&&dp[i-1][j]>1)
                {
                    dp[i][j]+=(dp[i-1][j]-1)/2.0;
                }
                if(j!=0&&dp[i-1][j-1]>1)
                {
                    dp[i][j]+=(dp[i-1][j-1]-1)/2.0;
                }
            }
        }
        return dp[query_row][query_glass]>1?1:dp[query_row][query_glass];
    }
}