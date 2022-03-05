class Solution {
    public int deleteAndEarn(int[] nums) {
        int freq[]=new int[10001];
        int max=0;
        for(int i:nums)
        {
            freq[i]++;
            max=Math.max(max,i);
        }
        int dp[]=new int[max+1];
        dp[1]=1*freq[1];
        for(int i=2;i<=max;i++)
        {
            dp[i]=Math.max(dp[i-1],i*freq[i]+dp[i-2]);
        }
        return dp[max];
    }
}