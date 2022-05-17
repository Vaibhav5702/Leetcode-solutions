class Solution {
    public int waysToSplitArray(int[] nums) {
        long rsum=0;
        for(int num:nums)
        {
            rsum+=num;
        }
        int splits=0;
        long lsum=0;
        for(int i=0;i<nums.length-1;i++)
        {
            lsum+=nums[i];
            rsum-=nums[i];
            if(lsum>=rsum)
                splits++;
        }
        return splits;
    }
}