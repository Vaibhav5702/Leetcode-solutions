class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int prev=nums[0],count=0;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]<=prev)
            {
                count+=prev+1-nums[i];
                nums[i]=prev+1;
            }
            prev=nums[i];
        }
        return count;
    }
}