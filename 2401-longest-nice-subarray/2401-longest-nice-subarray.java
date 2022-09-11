class Solution {
    public int longestNiceSubarray(int[] nums) {
        int max=1;
        int or=nums[0],left=0;
        for(int i=1;i<nums.length;i++)
        {
            while(left<i&&(nums[i]&or)!=0)
            {
                or^=nums[left];
                left++;
            }
            or|=nums[i];
            max=Math.max(max,i-left+1);
        }
        return max;
    }
}