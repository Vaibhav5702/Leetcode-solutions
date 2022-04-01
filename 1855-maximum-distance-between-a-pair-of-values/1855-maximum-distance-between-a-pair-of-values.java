class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int prev=0,max=0;
        for(int i=0;i<nums1.length;i++)
        {
            int low=prev, high=nums2.length-1;
            while(low<=high)
            {
                int mid=(low+high)/2;
                if(nums1[i]<=nums2[mid])
                {
                    max=Math.max(max,mid-i);
                    prev=mid;
                    low=mid+1;
                }
                else
                    high=mid-1;
            }
        }
        return max;
    }
}