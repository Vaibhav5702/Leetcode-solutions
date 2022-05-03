public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int i=0;
        for(i=1;i<nums.length;i++)
        {
            if(nums[i]<nums[i-1])
                break;
        }
        if(i==nums.length)
            return 0;
        int min=nums[i];
        for(;i<nums.length;i++)
        {
            min=Math.min(min,nums[i]);
        }
        int l=0;
        for(int j=0;j<nums.length;j++)
        {
            if(nums[j]>min)
            {
                l=j;
                break;
            }
        }
        i=nums.length-2;
        for(;i>=0;i--)
        {
            if(nums[i]>nums[i+1])
                break;
        }
        int max=nums[i];
        for(;i>=0;i--)
        {
            max=Math.max(max,nums[i]);
        }
        int r=0;
        for(int j=nums.length-1;j>=0;j--)
        {
            if(nums[j]<max)
            {
                r=j;
                break;
            }
        }
        return r-l+1;
    }
}