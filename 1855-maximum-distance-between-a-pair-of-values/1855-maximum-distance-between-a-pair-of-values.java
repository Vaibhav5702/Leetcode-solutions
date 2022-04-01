class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int j=0;
        int max=0;
        for(int i=0;i<nums1.length;i++)
        {
            while(j<nums2.length&&nums1[i]<=nums2[j])
            {
                j++;
            }
            max=Math.max(max,j-1-i);
            if(j==nums2.length)
                break;
            
        }
        return max;
    }
}