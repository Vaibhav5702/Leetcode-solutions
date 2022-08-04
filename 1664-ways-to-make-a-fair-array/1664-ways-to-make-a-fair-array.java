class Solution {
    public int waysToMakeFair(int[] nums) {
        int n=nums.length;
        int[] even=new int[n+1];
        int[] odd=new int[n+1];
        for(int i=n-1;i>=0;i--)
        {
            if(i%2==0)
            {
                even[i]=even[i+1]+nums[i];
                odd[i]=odd[i+1];
            }
            else
            {
                odd[i]=odd[i+1]+nums[i];
                even[i]=even[i+1];
            }
        }
        int esum=0,osum=0,count=0;
        for(int i=0;i<n;i++)
        {
            if(esum+odd[i+1]==osum+even[i+1])
                count++;
            if(i%2==0)
                esum+=nums[i];
            else
                osum+=nums[i];
        }
        return count;
    }
}