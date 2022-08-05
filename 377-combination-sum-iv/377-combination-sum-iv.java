class Solution {
    public int combinationSum4(int[] nums, int target) {
        int dp[]=new int[target+1];
        Arrays.sort(nums);
        dp[0]=1;
        for(int i=1;i<=target;i++)
        {
            for(int num:nums)
            {
                if(num<=i)
                    dp[i]+=dp[i-num];
                else
                    break;
                    
            }
        }
        return dp[target];
    }
}