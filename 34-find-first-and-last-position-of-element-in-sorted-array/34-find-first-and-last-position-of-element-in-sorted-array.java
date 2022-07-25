class Solution {
    public int[] searchRange(int[] nums, int target) {
        int a[]=new int[2];
        a[0]=firstPos(nums,target);
        a[1]=lastPos(nums,target);
        return a;
    }
    public int firstPos(int a[],int target)
    {
        int low=0,high=a.length-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(a[mid]>target)
            {
                high=mid-1;
            }
            else if(a[mid]<target)
            {
                low=mid+1;
            }
            else
            {
                if(mid==0||a[mid-1]!=a[mid])
                {
                    return mid;
                }
                else
                    high= mid-1;
            }
        }
        return -1;
    }
    public int lastPos(int a[],int target)
    {
        int low=0,high=a.length-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(a[mid]>target)
            {
                high=mid-1;
            }
            else if(a[mid]<target)
            {
                low=mid+1;
            }
            else
            {
                if(mid==a.length-1||a[mid+1]!=a[mid])
                {
                    return mid;
                }
                else
                    low=mid+1;
            }
        }
        return-1;
    }
}