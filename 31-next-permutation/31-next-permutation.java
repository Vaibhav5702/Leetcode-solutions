class Solution {
    public void nextPermutation(int[] nums) {
        int i=nums.length-1;
        while(i>0&&nums[i]<=nums[i-1])
        {
            i--;
        }
        if(i==0)
        {
            Arrays.sort(nums);
        }
        else
        {
            int j=i;
            while(j<nums.length&&nums[j]>nums[i-1])
            {
                j++;
            }
            int temp=nums[i-1];
            nums[i-1]=nums[j-1];
            nums[j-1]=temp;
            j=nums.length-1;
            while(i<j)
            {
                
                temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;
                j--;
            }
        }
    }
}