class Solution {
    public int movesToMakeZigzag(int[] nums) {
        if(nums.length<3)
            return 0;
        int n=nums.length;
        int even=0,odd=0;
        for(int i=0;i<n;i+=2)
        {
            int min=0;
            if(i==0)
                min=nums[i+1];
            else if(i==n-1)
                min=nums[i-1];
            else
                min=Math.min(nums[i-1],nums[i+1]);
            if(nums[i]>=min)
                even+=nums[i]-min+1;
        }
        for(int i=1;i<n;i+=2)
        {
            int min=0;
            if(i==0)
                min=nums[i+1];
            else if(i==n-1)
                min=nums[i-1];
            else
                min=Math.min(nums[i-1],nums[i+1]);
            if(nums[i]>=min)
                odd+=nums[i]-min+1;
        }
        return Math.min(even,odd);
    }
}