class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int count=1,prevDiff=0,sum=0,lIndex=0;
        for(int i=1;i<nums.length;i++)
        {
            int diff=nums[i]-nums[i-1];
            if(diff==prevDiff&&i-lIndex>=2)
            {
                sum+=count;
                count++;
            }
            else if(diff!=prevDiff)
            {
                prevDiff=diff;
                count=1;
                lIndex=i-1;
            }
                
        }
        return sum;
    }
}