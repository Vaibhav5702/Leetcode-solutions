class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[]=new int[amount+1];
        for(int i=1;i<dp.length;i++)
        {
            dp[i]=10001;
            for(int j=0;j<coins.length;j++)
            {
                if(i-coins[j]>=0)
                {
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]);
                }
            }
            dp[i]++;
        }
        return dp[amount]>10000?-1:dp[amount];
    }
}