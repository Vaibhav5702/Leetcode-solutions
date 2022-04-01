class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int low=0,high=0;
        for(int num:nums)
        {
            high=Math.max(high,num);
        }
        while(low<high)
        {
            int mid=(low+high)/2;
            if(check(nums,mid,maxOperations))
            {
                high=mid;
            }
            else
                low=mid+1;
        }
        return high;
    }
    public boolean check(int[] nums,int mid,int maxOperations)
    {
        int count=0;
        for(int num:nums)
        {
            count+=(int)Math.ceil((double)num/mid)-1;
            if(count>maxOperations)
                return false;
        }
        return true;
    }
}