class Solution {
    public int minOperations(int[] nums, int x) {
        int[] pre=new int[nums.length];
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            pre[i]=sum;
        }
        sum=0;
        int min=Integer.MAX_VALUE;
        for(int i=nums.length-1;i>0;i--)
        {
            sum+=nums[i];
            if(sum>x)
                break;
            if(sum==x)
            {
                min=Math.min(min,nums.length-i);
                break;
            }
            int idx=bsearch(i-1,x-sum,pre);
            if(idx!=-1)
                min=Math.min(min,nums.length-i+idx);
        }
        int idx=bsearch(nums.length-1,x,pre);
        if(idx!=-1)
            min=Math.min(min,idx);
        return min==Integer.MAX_VALUE?-1:min;
    }
    public int bsearch(int high,int sum,int[] arr)
    {
        int low=0;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(arr[mid]==sum)
                return mid+1;
            else if(arr[mid]<sum)
                low=mid+1;
            else
                high=mid-1;
        }
        return -1;
    }
}