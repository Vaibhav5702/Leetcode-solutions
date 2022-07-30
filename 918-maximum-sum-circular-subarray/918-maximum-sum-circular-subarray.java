class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int sum1=0,max=Integer.MIN_VALUE,min=Integer.MAX_VALUE,sum2=0,total=0;
        for(int i=0;i<nums.length;i++)
        {
            sum1=Math.max(sum1+nums[i],nums[i]);
            max=Math.max(max,sum1);
            total+=nums[i];
        }
        for(int i=1;i<nums.length-1;i++)
        {
            sum2=Math.min(sum2+nums[i],nums[i]);
            min=Math.min(min,sum2);
        }
        if(min==Integer.MAX_VALUE)
            return max;
        return Math.max(max,total-min);
    }
}