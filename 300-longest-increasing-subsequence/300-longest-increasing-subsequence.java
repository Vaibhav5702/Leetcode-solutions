class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[]=new int[nums.length];
        dp[0]=1;
        int max=1;
        for(int i=1;i<nums.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[i]>nums[j])
                {
                    dp[i]=Math.max(dp[j],dp[i]);
                }
            }
            dp[i]++;
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}