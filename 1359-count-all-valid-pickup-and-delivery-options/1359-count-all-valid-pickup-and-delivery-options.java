class Solution {
    public int countOrders(int n) {
        long[] dp=new long[n+1];
        dp[1]=1;
        for(int i=2;i<=n;i++)
        {
            dp[i]=((2*i-1)*i*dp[i-1])%1000000007;
        }
        return (int)dp[n];
    }
}