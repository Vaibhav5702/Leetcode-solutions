class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int prev=nums[0],count=0;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]<=prev)
            {
                prev++;
                count+=prev-nums[i];
            }
            else
            {
                prev=nums[i];
            }
        }
        return count;
    }
}