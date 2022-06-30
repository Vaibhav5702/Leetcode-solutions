class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int right=nums.length-1;
        long inc=0,max=nums[right],min=nums[0];
        while(max-min!=0)
        {
            inc+=max-min;
            min=max;
            max=nums[--right]+inc;
        }
        return (int)inc;
    }
}