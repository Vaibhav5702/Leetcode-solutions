class Solution {
    public int maxOperations(int[] nums, int k) {
        int count=0;
        Arrays.sort(nums);
        int low=0,high=nums.length-1;
        while(low<high)
        {
            int sum=nums[low]+nums[high];
            if(sum<k)
                low++;
            else if(sum>k)
                high--;
            else
            {
                count++;
                low++;
                high--;
            }
        }
        return count;
    }
}