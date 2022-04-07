class Solution {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int min=nums[nums.length-1]-nums[0];
        for(int i=0;i<nums.length-1;i++)
        {
            int diff=Math.max(nums[i]+k,nums[nums.length-1]-k)-Math.min(nums[0]+k,nums[i+1]-k);
            min=Math.min(min,diff);
        }
        return min;
    }
}